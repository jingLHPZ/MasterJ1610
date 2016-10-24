package com.sxt.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sxt.base.utils.HttpRequestDeviceUtils;
/**
 * 
 * @author pillar liu
 *
 */
public class PayUtil {  
	
	private static Logger logger = LoggerFactory.getLogger(PayUtil.class);
    
	/**
	 * 组装民生支付第三方支付参数
	 * @param orderNo
	 * @param amt
	 * @param type
	 * @return
	 */
	public static String buildForm(String orderNo, String amt,String type) {

		//商户编号
		String merchantid = PropertiesRead.use_classLoador().getProperty("CMBC.pay.id");
		//订单编号 商户的交易定单号,由商户网站生成,最大长度30
		String merorderid = orderNo;
		//金  额
		String amountsum = amt;
		//商品种类
		String subject = PropertiesRead.use_classLoador().getProperty("CMBC.pay.type");//"empty";
		//币  种 01 为cny
        String currencytype = "01";
        //自动调转取货页面0→不跳转；1→跳转
        String autojump = "1";
        //跳转等待时间
        String waittime	= "0";
        
        //商户取货URL	
        String merurl = PropertiesRead.use_classLoador().getProperty("CMBC.pay.return.page.url");      
        //是否通知商户: 0→不通知；1→通知
        String informmer = "1";
        //商户通知URL
        String informurl = PropertiesRead.use_classLoador().getProperty("CMBC.pay.return.notify.url");
        
    	/**
    	 *  商户返回确认:	0→不返回；1→返回
		*/
        String confirm = "1";
        
        //支付银行
        String merbank = "empty";
        //支付类型 0→即时到账；1→担保交易
        String tradetype = "0";
   
        //是否在商户端选择银行:0→其他；1→在商户端选择银行
        String bankInput = "0";
        //接口版本
        String strInterface = "5.00";
        
        //备  注 (可选) 支付备注信息,最大长度50
        String remark = "充值";
        //支付银行卡类型 00→借贷混合；01→纯借记
        String bankcardtype = "00";
        
		//商品描述
		String pdtdnm = "虚拟商品";
		//商品描述地址
		String pdtdetailurl = PropertiesRead.use_classLoador().getProperty("CMBC.pay.return.detail.url");
		//支付密钥(必填): 需在支付平台进行设置,可登录商户管理系统进行维护,用于上送商户支付及下传支付结果加密
        String MD5key = PropertiesRead.use_classLoador().getProperty("CMBC.pay.pwd");
        
       //拼接加密的源字符串
       String mac_src="merchantid="+merchantid+"&merorderid="+merorderid
        			+"&amountsum="+amountsum+"&subject="+subject
        			+"&currencytype="+currencytype+"&autojump="+autojump
        			+ "&waittime=" + waittime +"&merurl="+merurl
        			+ "&informmer=" + informmer +"&informurl=" +informurl
        			+ "&confirm=" + confirm + "&merbank=" + merbank
        			+ "&tradetype=" + tradetype + "&bankInput=" + bankInput
        			+ "&interface=" + strInterface + "&bankcardtype=" + bankcardtype
        			+ "&pdtdetailurl=" + pdtdetailurl + "&merkey="+MD5key;
       System.out.println("mac_src:"+mac_src);
       logger.info("log4j mac_src:"+mac_src);
        
        String mac = Crypto.GetMessageDigest(mac_src);
        
        System.out.println("mac:"+mac);
        logger.info("log4j mac:"+mac);
   

        // 把请求参数打包成map
        Map<String, String> sParaTemp = new HashMap<String,String>();
        sParaTemp.put("merchantid", merchantid);
        sParaTemp.put("merorderid", merorderid);
        sParaTemp.put("amountsum", amountsum);
        sParaTemp.put("subject", subject);
        sParaTemp.put("currencytype", currencytype);
        sParaTemp.put("autojump", autojump);
        sParaTemp.put("waittime", waittime);
        sParaTemp.put("merurl", merurl);
        sParaTemp.put("informmer", informmer);
        sParaTemp.put("informurl", informurl);
        sParaTemp.put("confirm", confirm);
        sParaTemp.put("merbank", merbank);
        sParaTemp.put("tradetype", tradetype);
        sParaTemp.put("bankInput", bankInput);
        sParaTemp.put("interface", strInterface);
        sParaTemp.put("remark", remark);
        sParaTemp.put("bankcardtype", bankcardtype);
        sParaTemp.put("pdtdnm", pdtdnm);
        sParaTemp.put("pdtdetailurl", pdtdetailurl);
        sParaTemp.put("mac", mac);

        //建立请求
        String sHtmlText = buildRequest(PropertiesRead.use_classLoador().getProperty("CMBC.pay.url"), sParaTemp, "post");

        logger.info("McPay request: {}", sHtmlText);

        return sHtmlText;
    }
	/**
	 * 生成页面数据
	 * @param url
	 * @param sPara
	 * @param strMethod
	 * @return
	 */
	public static String buildRequest(String url, Map<String, String> sPara, String strMethod) {
        ArrayList keys = new ArrayList(sPara.keySet());
        StringBuffer sbHtml = new StringBuffer();
        sbHtml.append("<form id=\"paySubForm\" name=\"paySubForm\" action=\"" + url + "\" method=\"" + strMethod + "\">");

        for(int i = 0; i < keys.size(); ++i) {
            String name = (String)keys.get(i);
            String value = (String)sPara.get(name);
            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        sbHtml.append("<input type=\"submit\" name=\"b1\" value=\"确认\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms[\'paySubForm\'].submit();</script>");
        //System.out.println(sbHtml.toString());
        //logger.info(sbHtml.toString());
        return sbHtml.toString();
    }
	
	/** 
	 * 金额验证
     */  
    public static boolean getMoneyCheck(String str){  
        String regEx="^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$";
        Pattern pattern = Pattern.compile(regEx);  
        Matcher matcher = pattern.matcher(str);  
        if(!matcher.matches()){  
            return false;  
        }else{
        	Money nero = new Money("0.0");
        	Money after = new Money(str);
        	if (after.greaterThan(nero))
        		return true;
        	else
        		return false;
        }
        //System.out.println(matcher.group(1));   //分组的索引值是从1开始的，所以取第一个分组的方法是m.group(1)而不是m.group(0)。  
    }
    
    /**
     * 生成四位数字随机数
     * @return
     */
    public static String randomStr(){
    	 int max=9999;
         int min=1000;
         Random random = new Random();
         int s = random.nextInt(max)%(max-min+1) + min;
         return String.valueOf(s);
    }
    /**
     * 生成支付流水号
     * @param uid
     * @return
     */
    public static String getPaySystemTraceNo(Integer uid){
    	return String.valueOf(System.currentTimeMillis()).concat(PayUtil.randomStr()).concat(String.valueOf(uid));
    }
    
    public static void main(String [] args){
    	System.out.println((new BigDecimal("0.0").compareTo(new BigDecimal("0.0")))==0);
    }
    
    public static String findBankInfo(String bankNo) {
        switch (bankNo) {
            case "03080000":
                return "招商银行";
            case "01020000":
                return "中国工商银行";
            case "01030000":
                return "中国农业银行";
            case "01050000":
                return "中国建设银行";
            case "01040000":
                return "中国银行";
            case "03100000":
                return "浦发银行";
            case "03010000":
                return "中国交通银行";
            case "03050000":
                return "中国民生银行";
            case "03060000":
                return "广东发展银行";
            case "03020000":
                return "中信银行";
            case "03040000":
                return "华夏银行";
            case "03090000":
                return "兴业银行";
            case "14055810":
                return "广州农村商业银行";
            case "04135810":
                return "广州银行";
            case "65012900":
                return "上海农村商业银行";
            case "04031000":
                return "北京银行";
            case "03170000":
                return "渤海银行";
            case "14181000":
                return "北京农商银行";
            case "04240001":
                return "南京银行";
            case "03030000":
                return "中国光大银行";
            case "26150704":
                return "东亚银行";
            case "01033320":
                return "宁波银行";
            case "04233310":
                return "杭州银行";
            case "05105840":
                return "平安银行";
            case "04403600":
                return "徽商银行";
            case "03160000":
                return "浙商银行";
            case "04012900":
                return "上海银行";
            case "01000000":
                return "中国邮政储蓄银行";
            case "05213000":
                return "江苏银行";
            case "04202220":
                return "大连银行";
            default:
                return "";
        }
    }
    
    /**
	 * 组装通联支付第三方支付参数
	 * @param orderNo
	 * @param amt
	 * @param type
	 * @return
	 */
	public static String allInPaybuildForm(String merOrderNo, String amt,String type,HttpServletRequest request) {
		// 字符集	2 不可空	默认填1；1代表UTF-8、2代表GBK、3代表GB2312；
        String inputCharset = "1";
        //商户取货URL	
        String pickupUrl = PropertiesRead.use_classLoador().getProperty("ALLIN.pay.return.page.url").trim();      
        //服务器接受支付结果的后台地址	100	不为空	通知商户网站支付结果的url地址
        String receiveUrl = PropertiesRead.use_classLoador().getProperty("ALLIN.pay.return.notify.url").trim();
        //网关接收支付请求接口版本	10	不可空	固定填v1.0 
        String version = "v1.0";
        //网关页面显示语言种类	2	不为空	默认填1，固定选择值：1；1代表简体中文、2代表繁体中文、3代表英文
    	String language ="1";
    	/*　signType	签名类型	2	不可空	默认填1，固定选择值：0、1；
    	0表示订单上送和交易结果通知都使用MD5进行签名
    	1表示商户用使用MD5算法验签上送订单，通联交易结果通知使用证书签名
    	Asp商户不使用通联dll文件签名验签的商户填0　*/
    	String signType = "1";

		//商户编号
		String merchantId = PropertiesRead.use_classLoador().getProperty("ALLIN.pay.id").trim();	
		
		if(HttpRequestDeviceUtils.isMobileDevice(request))        
        	merchantId = PropertiesRead.use_classLoador().getProperty("ALLIN.mobile.pay.id").trim();
		
		String allinPayType = request.getParameter("allinPayType");
		if ("b2c".equals(allinPayType)) {
			merchantId = PropertiesRead.use_classLoador().getProperty("ALLIN.pay.id").trim();
		} else if ("b2b".equals(allinPayType)) {
			merchantId = PropertiesRead.use_classLoador().getProperty("ALLIN.mobile.pay.id").trim();
		}
		
		//商户订单号	50	不可空	字符串，只允许使用字母、数字、- 、_,并以字母或数字开头；每商户提交的订单号，必须在当天的该商户所有交易中唯一
		String orderNo = merOrderNo;
		/* 商户订单金额	10	不可空	整型数字，金额与币种有关
		如果是人民币，则单位是分，即10元提交时金额应为1000
		如果是美元，单位是美分，即10美元提交时金额为1000 */
		Money borrowMoney = new Money(amt, Currency.getInstance("CNY"));
		String orderAmount = String.valueOf(borrowMoney.getCent());
	
		/* 订单金额币种类型	3	不可空	默认填0
		0和156代表人民币、840代表美元、344代表港币，跨境支付商户不建议使用0 */
		String orderCurrency = "0";
		//商户订单提交时间	14	不可空	日期格式：yyyyMMDDhhmmss，例如：20121116020101
		String orderDatetime = DateUtil.longDate(new Date()).trim();
		/*
		 * 支付方式	2	不可空	固定选择值：0、1、4、11、23、28
			接入互联网关时，默认为间连模式，填0
			若需接入外卡支付，只支持直连模式，即固定上送payType=23，issuerId=visa或mastercard
			0代表未指定支付方式，即显示该商户开通的所有支付方式
			1个人储蓄卡网银支付
			4企业网银支付
			11个人信用卡网银支付
			23外卡支付
			28认证支付
			非直连模式，设置为0；直连模式，值为非0的固定选择值
		 */
		String payType = "0";
		
		 //如果手机微信
        if(HttpRequestDeviceUtils.isMobileDevice(request))           
        	payType = "27";
		
		String key = PropertiesRead.use_classLoador().getProperty("ALLIN.key").trim();
		//构造订单请求对象，生成signMsg。
		com.allinpay.ets.client.RequestOrder requestOrder = new com.allinpay.ets.client.RequestOrder();
		if(null!=inputCharset&&!"".equals(inputCharset)){
			requestOrder.setInputCharset(Integer.parseInt(inputCharset));
		}
		requestOrder.setPickupUrl(pickupUrl);
		requestOrder.setReceiveUrl(receiveUrl);
		requestOrder.setVersion(version);
		if(null!=language&&!"".equals(language)){
			requestOrder.setLanguage(Integer.parseInt(language));
		}
		requestOrder.setSignType(Integer.parseInt(signType));
		requestOrder.setPayType(Integer.parseInt(payType));
		
		requestOrder.setMerchantId(merchantId);
		requestOrder.setOrderNo(orderNo);
		requestOrder.setOrderAmount(Long.parseLong(orderAmount));
		requestOrder.setOrderCurrency(orderCurrency);
		requestOrder.setOrderDatetime(orderDatetime);
		requestOrder.setKey(key); //key为MD5密钥，密钥是在通联支付网关会员服务网站上设置。

		String strSrcMsg = requestOrder.getSrc(); // 此方法用于debug，测试通过后可注释。
		System.out.println("strSrcMsg:"+strSrcMsg);
		String strSignMsg = requestOrder.doSign(); // 签名，设为signMsg字段值。
		System.out.println("strSignMsg:"+strSignMsg);
	
    

        // 把请求参数打包成map
        Map<String, String> sParaTemp = new HashMap<String,String>();
        sParaTemp.put("inputCharset", inputCharset);
        sParaTemp.put("pickupUrl", pickupUrl);
        sParaTemp.put("receiveUrl",receiveUrl);
        sParaTemp.put("version",version);
        sParaTemp.put("language",language);
        sParaTemp.put("signType",signType);
        sParaTemp.put("merchantId",merchantId);
        sParaTemp.put("orderNo",orderNo);
        sParaTemp.put("orderAmount",orderAmount);
        sParaTemp.put("orderCurrency",orderCurrency);
        sParaTemp.put("orderDatetime",orderDatetime);
        sParaTemp.put("payType",payType);
        sParaTemp.put("signMsg",strSignMsg);
        //建立请求
        String payUrl =PropertiesRead.use_classLoador().getProperty("ALLIN.pay.url");
        //如果手机微信
        if(HttpRequestDeviceUtils.isMobileDevice(request))           
        	payUrl = PropertiesRead.use_classLoador().getProperty("ALLIN.pay.WeChat.url");
        
        
        String sHtmlText = buildRequest(payUrl, sParaTemp, "post");

        logger.info("ALLINPay request: {}", sHtmlText);

        return sHtmlText;
    }
}  