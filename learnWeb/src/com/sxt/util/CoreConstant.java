package com.sxt.util;

import java.math.BigDecimal;

public interface CoreConstant {
	
	public static final String UTF_8 = "UTF-8";

    public static final String ISO_8859_1 = "ISO-8859-1";
    
    public static final BigDecimal DEFAULT_BIGDECIMAL_VALUE = BigDecimal.ZERO;
    
    public static final Integer CALC_DECIMAL = 2;
    
    public static final String DES_KEY = "app$#*@&";
    
    public static final String MERCH_ANTNO = PropertiesRead.use_classLoador().getProperty("CMBC.quick.pay.merchantNo");
    
    public static final String MSG_TYPE = "0001";
    
    public static final String CHAN_ID = "99";
    
    public static final String VERSION ="01";
    
    public static final String RESP_CODE = "C000000000";
    
    public static final String BUSINESS_SECRET_KEY = PropertiesRead.use_classLoador().getProperty("CMBC.quick.pay.business.secret.key");
    
    public static final String DATA_SECRET_KEY = PropertiesRead.use_classLoador().getProperty("CMBC.quick.pay.data.secret.key");
    
    public static final String SUB_JECT = PropertiesRead.use_classLoador().getProperty("CMBC.quick.pay.subject");
    
    public static final String XML = "xml";
    
    public static final String MAC = "mac";
    
    public static final String QUICK_URL= PropertiesRead.use_classLoador().getProperty("CMBC.quick.pay.url");
    
    public static final String CHECK_URL= "http://public.umbpay.com.cn:8086/secCenter/msgProcess/acceptReq.do";
    
    public static final String BACK_URL = PropertiesRead.use_classLoador().getProperty("CMBC.quick.back.url");
    
    public static final String DEFAULT_STRING_VALUE = "";
    
    public static final String TRAN_CODE_QP0001 ="QP0001";

    public static final String CHECK_CODE_SC0002 ="SC0002";

    public static final String TRAN_CODE_QP0002 ="QP0002";
    
    public static final String TRAN_CODE_QP0003 ="QP0003";
    
    public static final String TRAN_CODE_QP0004 ="QP0004";
    
    public static final String TRAN_CODE_QP0005 ="QP0005";
    
    public static final String TRAN_CODE_QP0006 ="QP0006";
    
    public static final String TRAN_CODE_QP0007 ="QP0007";
    
    //银行列表
    
 

}
