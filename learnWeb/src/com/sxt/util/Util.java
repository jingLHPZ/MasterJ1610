package com.sxt.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.alibaba.fastjson.JSON;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.Members;
import com.sxt.models.thirdInteraction.TransactionResponseBase;
import com.sxt.models.thirdInteraction.TransactionResponseCardInfo;
import com.sxt.models.thirdInteraction.TransactionResponseQP0003;
import com.sxt.page.util.ObjectUtils;
import com.sun.xml.internal.ws.util.UtilException;

public class Util {

    /**
     * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
     *
     * @return 以yyyyMMddHHmmss为格式的当前系统时间
     */
    public static String getOrderNum() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(date);
    }

    public static String getOrderAutoId() {
        return getOrderNum() + Util.getRandom(10);
    }

    public static String getTranFlowAutoId() {
        return CoreConstant.MERCH_ANTNO + getOrderNum() + Util.getRandom(10);
    }

    public static String getRandom(int count) {
        String reStr = "";
        Random ra = new Random();
        for (int i = 0; i < count; i++) {
            reStr += ra.nextInt(10);
        }
        return reStr.trim();
    }

    public static String getRandomLenght(Integer len) {
        java.util.Random r = new java.util.Random();

        String value = new Integer(Math.abs(r.nextInt())).toString();
        if (len < value.length()) {
            return value.substring(0, len);
        } else {
            return value;
        }
    }

    public static String maskString(String fromData) {
        if (fromData == null) {
            return CoreConstant.DEFAULT_STRING_VALUE;
        } else {
            return fromData;
        }
    }

    public static Integer maskInteger(Integer fromData) {
        if (fromData == null) {
            return 0;
        } else {
            return fromData;
        }
    }

    public static BigDecimal maskBigDecimal(BigDecimal fromData) {
        if (fromData == null) {
            return CoreConstant.DEFAULT_BIGDECIMAL_VALUE;
        } else {
            return fromData.setScale(CoreConstant.CALC_DECIMAL, BigDecimal.ROUND_HALF_UP);
        }
    }

    public static Map<String, Object> responseSubString(String subString) {
        int indexMac = subString.lastIndexOf("&mac=");
        if (indexMac < 0) {
            return null;
        }

        String macString = subString.substring(indexMac + 5);
        if (StringUtils.isBlank(macString)) {
            return null;
        }
        String xmlString = subString.substring(subString.indexOf("<"), subString.lastIndexOf("&mac"));
        if (StringUtils.isBlank(xmlString)) {
            return null;
        }
        Map<String, Object> responseMap = new HashMap<String, Object>(2);
        responseMap.put("mac", macString);
        responseMap.put("xml", xmlString);
        return responseMap;
    }

    /**
     * 这个方法临时用在这
     * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
     *
     * @param strxml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static Map<String, String> doXMLParse(String strxml) throws JDOMException, IOException {
        if (null == strxml || "".equals(strxml)) {
            return null;
        }

        Map<String, String> sParaTemp = new HashMap<String, String>();
        InputStream in = String2Inputstream(strxml);
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List<?> list = root.getChildren();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            String k = e.getName();
            String v = "";
            List<?> children = e.getChildren();

            if (children.isEmpty()) {
                v = e.getTextNormalize();//new String((e.getTextNormalize()).getBytes(),"UTF-8");
                sParaTemp.put(k, v);
            } else {
                getChildrenText(sParaTemp, children);
            }


        }

        //关闭流
        in.close();

        return sParaTemp;
    }

    /**
     * 获取子结点的xml
     *
     * @param children
     * @return String
     */
    public static Map<String, String> getChildrenText(Map<String, String> sortedMap, List children) {
        if (!children.isEmpty()) {
            Iterator it = children.iterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List<?> list = e.getChildren();
                if (!list.isEmpty()) {
                    //sb.append(getChildrenText(sortedMap,list));
                }
                sortedMap.put(name, value);
            }
        }

        return sortedMap;
    }

    public static InputStream String2Inputstream(String str) throws UnsupportedEncodingException {
        String json = new String(str.getBytes("ISO8859-1"), "UTF-8");
        return new ByteArrayInputStream(str.getBytes("UTF-8"));
    }

    /**
     * 生成四位数字随机数
     *
     * @return
     */
    public static String randomStr() {
        int max = 9999;
        int min = 1000;
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return String.valueOf(s);
    }

    /**
     * 生成支付流水号
     *
     * @param uid
     * @return
     */
    public static String getPaySystemTraceNo(Integer uid) {
        return String.valueOf(System.currentTimeMillis()).concat(PayUtil.randomStr()).concat(String.valueOf(uid));
    }

    public static void transMapToBean(Map<String, String> map, Object obj) {
        if (map == null || obj == null) {
            return;
        }
        try {
            BeanUtils.populate(obj, map);
        } catch (Exception e) {
            throw new UtilException("map convert bean exception");
        }
    }

    public static void transMapObjectToBean(Map<String, Object> map, Object obj) {
        if (map == null || obj == null) {
            return;
        }
        try {
            BeanUtils.populate(obj, map);
        } catch (Exception e) {
            throw new UtilException("map convert bean exception");
        }
    }

    /**
     * @param @param  object
     * @param @return 参数
     * @return String    返回类型
     * @throws
     * @Title: percentFormat
     * @Description: TODO(百分比, 保留两位小数)
     */
    public static String percentFormat(Object object) {
        if (object == null) {
            return "";
        }
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        return percent.format(object);
    }

    public static void test(TransactionResponseBase transactionResponseBase) {
        if (transactionResponseBase instanceof TransactionResponseQP0003) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static String objectToJsonToEncrypt(Object object) throws Exception {
        if (object == null) {
            return null;
        }
        JSON jsonObject = (JSON) JSON.toJSON(object);
        String strObject = jsonObject.toString();
        return DesUtil.encryptDES(strObject, CoreConstant.DES_KEY);
    }

    /**
     * 校验是否含有小数
     *
     * @param str
     * @return
     */
    public static Boolean checkNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher((CharSequence) str);
        return matcher.matches();
    }

    public static void reflectObject(Object oldEntity, Object newEntity) throws ClassNotFoundException {
        Method[] method1 = oldEntity.getClass().getMethods();
        Method[] method2 = newEntity.getClass().getMethods();
        Map<String, Object> putMap = new HashMap<String, Object>();
        for (Method method : method1) {
            String getter = method.getName();
            if ("getId".equalsIgnoreCase(method.getName())) continue;
            try {

                String setter = "set" + (getter.startsWith("get") ? getter.substring(3) : getter.substring(3));
                if (getter.equalsIgnoreCase("wait") || getter.equalsIgnoreCase("notify") ||
                        getter.equalsIgnoreCase("notifyAll") || getter.equalsIgnoreCase("hashCode") || getter.equalsIgnoreCase("equals")) {
                    continue;
                }
                //Class[] type = method.getParameterTypes();
                for (Method methodb : method2) {
                    String getterb = methodb.getName();
                    if ("getId".equalsIgnoreCase(getterb)) continue;
                    if (getter.equalsIgnoreCase(getterb)) {
                        if (!getter.substring(0, 3).equalsIgnoreCase("set")) {
                            Object value = method.invoke(oldEntity, new Object[]{});
                            putMap.put(setter, value);
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Method method : method2) {
            String getter = method.getName();
            Class[] parameterType = method.getParameterTypes();
            String setter = "set" + (getter.startsWith("get") ? getter.substring(3) : getter.substring(3));
            for (String key : putMap.keySet()) {
                if (getter.equalsIgnoreCase(key)) {
                    for (Class class1 : parameterType) {
                        try {
                            Method setterMethod = newEntity.getClass().getMethod(setter, class1);
                            try {
                                setterMethod.invoke(newEntity, new Object[]{putMap.get(key)});
                            } catch (IllegalAccessException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } catch (IllegalArgumentException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }


    public static void main(String args[]) throws Exception {
/*	  Map<String, Object> map = new HashMap<String, Object>();
      map.put("cardNum", "2");
	  map.put("custId", "100031");
	  if(MapUtils.isEmpty(map)){
		  System.out.println(true);
	  }else{
		  System.out.println("属性不为空");
	  }*/
        TransactionResponseCardInfo transactionResponseCardInfo = new TransactionResponseCardInfo();
        transactionResponseCardInfo.setBankNo("1");
        transactionResponseCardInfo.setPhoneNo("123456");
        boolean flag = ObjectUtils.isObjectEmpty(transactionResponseCardInfo);
        System.out.println(flag);
    /*  map.put("transactionResponseCardInfo", transactionResponseCardInfo);
	  TransactionResponseQP0004 transactionResponseQP0004 = new TransactionResponseQP0004();*/
	 /* transMapObjectToBean(map,transactionResponseQP0004);

	  System.out.println(transactionResponseQP0004.getCardNum()+","+
	  transactionResponseQP0004.getCustId()+transactionResponseQP0004.getTransactionResponseCardInfo().getBankNo()
	  +transactionResponseQP0004.getTransactionResponseCardInfo().getPhoneNo());
	  */
	  
	  
	  
	  
	  /*
		String mac = DigestUtils.md5Hex("<?xml version=\"1.0\" encoding=\"UTF-8\"?><message><head><version>01</version><msgType>0002</msgType><chanId>99</chanId><merchantNo>1173</merchantNo><clientDate>20151028100510</clientDate><serverDate>20151028095554</serverDate><tranFlow>1173201510281009126093883985</tranFlow><tranCode>QP0002</tranCode><respCode>C000000000</respCode><respMsg>交易成功</respMsg></head><body><merOrderId>201510281009120948753583</merOrderId><custId>oerTh2tL5XW/FBs7fRssOBMzP0e1Jc33</custId><phoneToken>828009</phoneToken></body></message>"+CoreConstant.BUSINESS_SECRET_KEY);
		System.out.println("系统时间"+getOrderNum());
		System.out.println("系统唯一订单号"+getTranFlowAutoId());
		System.out.println("数据库唯一订单号"+getOrderAutoId());
		
		String textString = "xml=<?xml version=\"1.0\" encoding=\"UTF-8\"?><message><head><version>01</version><msgType>0002</msgType><chanId>99</chanId><merchantNo>1173</merchantNo><clientDate>20151028100510</clientDate><serverDate>20151028095554</serverDate><tranFlow>1173201510281009126093883985</tranFlow><tranCode>QP0002</tranCode><respCode>C000000000</respCode><respMsg>交易成功</respMsg></head><body><merOrderId>201510281009120948753583</merOrderId><custId>oerTh2tL5XW/FBs7fRssOBMzP0e1Jc33</custId><phoneToken>828009</phoneToken></body></message>&mac=945375619b7c77d32a21b7d9f18ed0bf";
		
		System.out.println(mac.equals("945375619b7c77d32a21b7d9f18ed0bf"));
		int indexMac = textString.lastIndexOf("&mac=");
		int indexXmlStart = textString.indexOf("<");
		int indexXmlEnd = textString.lastIndexOf("&mac");
		String xmlString = textString.substring(textString.indexOf("<"),textString.lastIndexOf("&mac"));
		if(indexMac < 0){
			return;
		}
		System.out.println(indexXmlStart+","+indexXmlEnd+","+xmlString);
		String toStr = textString.substring(indexMac+5);
		<list name=”fileList”>
    <!-- 第1条记录 -->
    	<list name=\"fileList\"><row><fileName>1026_S0120120620_00001.txt</fileName><mac>23445EFDACB5EFD3434345EFD45455E</mac></row><row><fileName>1026_S0120120620_00001.txt</fileName><mac>23445EFDACB5EFD3434345EFD45455E</mac></row></list>
        <row><fileName>1026_S0120120620_00001.txt</fileName><mac>23445EFDACB5EFD3434345EFD45455E</mac></row><row><fileName>1026_S0120120620_00001.txt</fileName><mac>23445EFDACB5EFD3434345EFD45455E</mac></row></list>

		System.out.println(toStr);*/

        //String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><message><head><version>01</version><msgType>0002</msgType><chanId>99</chanId><merchantNo>1173</merchantNo><clientDate>20151028100510</clientDate><serverDate>20151028095554</serverDate><tranFlow>1173201510281009126093883985</tranFlow><tranCode>QP0002</tranCode><respCode>C000000000</respCode><respMsg>交易成功</respMsg></head><body><merOrderId>201510281009120948753583</merOrderId><custId>oerTh2tL5XW/FBs7fRssOBMzP0e1Jc33</custId><phoneToken>828009</phoneToken><list name=\"fileList\"><row><fileName>1026_S0120120620_00001.txt</fileName><mac>23445EFDACB5EFD3434345EFD45455E</mac></row><row><fileName>1026_S0120120620_00001.txt</fileName><mac>23445EFDACB5EFD3434345EFD45455E</mac></row></list></body></message>";
        //SortedMap<String, String> sortedMap =  doXMLParse(xml);
        //System.out.println(sortedMap.get("respCode")+","+sortedMap.get("respMsg")+","+sortedMap.get("phoneToken"));

        //String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><employee><id>12311</id><name>zhangsan</name><add>dalian</add><age>18</age></employee>";


        Members members = new Members();
        members.setUid(1444);
        members.setIsVip("222");
        LocalUserDto localUserDto = new LocalUserDto();
        reflectObject(members, localUserDto);
        System.out.println(localUserDto.getUid() + "," + localUserDto.getIsVip());
    }


}
