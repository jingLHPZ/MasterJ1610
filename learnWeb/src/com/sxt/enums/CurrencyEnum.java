/**
 * 外卡收单系统
 * com.masapay.common.enums
 * CurrencyEnum.java
 * 
 * 2013-1-11-下午6:17:45
 *  2013乾汇公司-版权所有
 * 
 */
package com.sxt.enums;

import java.util.Currency;

import com.sxt.util.Money;


/**
 * 
 * 币种枚举。<br>
 * 参考 <a href="http://en.wikipedia.org/wiki/ISO_4217">http://en.wikipedia.org/
 * wiki/ISO_4217</a>
 * 
 * <p>
 * pillar liu
 * 
 * 2015-09-06 下午6:17:45
 * 
 * @version 1.0.0
 * 
 */
public enum CurrencyEnum {
    /**
     * "CNY", "156", "CNY", "人民币"
     */
    CNY("CNY", "156", "CNY", "人民币","01"),

    /**
     * "USD", "840", "USD", "美元"
     */
    USD("USD", "840", "USD", "美元","02"),

    /**
     * "JPY", "392", "JPY", "日元"
     */
    JPY("JPY", "392", "JPY", "日元","10"),

    /**
     * "RUB", "643", "RBI", "卢布"
     */
    RUB("RUB", "643", "RBI", "卢布","15"),

    /**
     * "EUR", "978", "EUR", "欧元"
     */
    EUR("EUR", "978", "EUR", "欧元","03"),

    /**
     * "GBP", "826", "GBP", "英镑"
     */
    GBP("GBP", "826", "GBP", "英镑","04"),

    /**
     * "HKD", "344", "HKD", "港币"
     */
    HKD("HKD", "344", "HKD", "港币","05"),

    /**
     * "AUD", "036", "AUD", "澳元"
     */
    AUD("AUD", "036", "AUD", "澳元","07"),

    /**
     * "CAD","124","CAD","加元"
     */
    CAD("CAD", "124", "CAD", "加元","08"),

    /**
     * "INR","356","INR","印度卢比"
     */
    INR("INR", "356", "INR", "印度卢比","09"),

    /**
     * "KRW","410","KRW","韩元"
     */
    KRW("KRW", "410", "KRW", "韩元","11"),

    /**
     * "MOP","446","MOP","澳门元"
     */
    MOP("MOP", "446", "MOP", "澳门元","12"),

    /**
     * "MYR","458","MYR","马来西亚林吉特"
     */
    MYR("MYR", "458", "MYR", "马来西亚林吉特","13"),

    /**
     * "NZD", "554", "NZD", "新西兰元"
     */
    NZD("NZD", "554", "NZD", "新西兰元","14"),

    /**
     * "SGD","702","SGD","新加坡元"
     */
    SGD("SGD", "702", "SGD", "新加坡元","16"),

    /**
     * "CHF","756","CHF","瑞士法郎"
     */
    CHF("CHF", "756", "CHF", "瑞士法郎","17"),

    /**
     * "THB","764","THB","泰铢"
     */
    THB("THB", "764", "THB", "泰铢","18"),

    /**
     * "TWD","901","TWD","新台币"
     */
    TWD("TWD", "901", "TWD", "新台币","06"),
    
    /**
     * "KWD", "414", "Kuwaiti dinar", "科威特第纳尔"
     */
    KWD("KWD", "414", "Kuwaiti dinar", "科威特第纳尔","26"),
    
    /**
     * "BHD", "048", "Bahraini dinar", "巴林第纳尔"
     */
    BHD("BHD", "048", "Bahraini dinar", "巴林第纳尔","27"),
    
    /**
     * "OMR", "512", "Omani rial", "阿曼里亚尔"
     */
    OMR("OMR", "512", "Omani rial", "阿曼里亚尔","28"),
    
    /**
     * "JOD", "400", "Jordanian dinar", "约旦第纳尔"
     */
    JOD("JOD", "400", "Jordanian dinar", "约旦第纳尔","29"),
    
    /**
     * "QAR", "634", "Qatari riyal", "卡塔尔里亚尔"
     */
    QAR("QAR", "634", "Qatari riyal", "卡塔尔里亚尔","30"),
    
    /**
     * "SAR", "682", "Saudi riyal", "沙特里亚尔"
     */
    SAR("SAR", "682", "Saudi riyal", "沙特里亚尔","31"),
    
    /**
     * "AED", "784", "United Arab Emirates dirham", "阿拉伯联合酋长国迪拉姆"
     */
    AED("AED", "784", "United Arab Emirates dirham", "阿拉伯联合酋长国迪拉姆","24"),
    
    /**
     * "SEK","752","SEK","瑞典克朗 "
     */
    SEK("SEK","752","SEK","瑞典克朗 ","20"),
    
    /**
     * "DKK","208","DKK","丹麦克朗 "
     */
    DKK("DKK","208","DKK","丹麦克朗 ","23"),
    
    /**
     * "NOK","578","NOK","挪威克朗 "
     */
    NOK("NOK","578","NOK","挪威克朗 ","25"),
    
    /**
     * "ZAR","710","ZAR","南非兰特"
     */
    ZAR("ZAR","710","ZAR","南非兰特","35"),
    
    PHP("PHP","608","Philippine Peso","菲律宾比索","19"),

    TRY("TRY","949","Turkish Lira","土耳其里拉","21"),
    
    ILS("ILS","376","Israeli Shekel","以色列谢尔克","22"),
    
    BRL("BRL","986","Brazilian Real","巴西里尔","36"),
    
    CZK("CZK","203","Czech koruna","捷克克朗","32"),
    
    MXN("MXN","484","Mexican peso","墨西哥比索","33"),
    
    PLN("PLN","985","Polish złoty","波兰兹罗提","34"),

    HUF("HUF","348","Hungarian Forint","匈牙利福林","37"),
    
    AFN("AFN","971","Afghan afghani","阿富汗尼","38"),

    ALL("ALL","008","Albanian lek","阿尔巴尼亚列克","39"),

    AMD("AMD","051","Armenian dram","亚美尼亚德拉姆","40"),

    ANG("ANG","532","Netherlands Antillean guilder","荷兰盾","41"),

    AOA("AOA","973","Angolan kwanza","安哥拉宽扎","42"),

    ARS("ARS","032","Argentine peso","阿根廷比索","43"),

    AWG("AWG","533","Aruban florin","阿鲁巴弗罗林","44"),

    AZN("AZN","944","Azerbaijani manat","阿塞拜疆马纳特","45"),

    BAM("BAM","977","Bosnia and Herzegovina convertible mark","波斯尼亚和黑塞哥维那可兑换马克","46"),

    BBD("BBD","052","Barbados dollar","巴巴多斯元","47"),

    BDT("BDT","050","Bangladeshi taka","孟加拉塔卡","48"),

    BGN("BGN","975","Bulgarian lev","保加利亚列弗","49"),

    BIF("BIF","108","Burundian franc","布隆迪法郎","50"),

    BMD("BMD","060","Bermudian dollar","百慕大元","51"),

    BND("BND","096","Brunei dollar","文莱元","52"),

    BOB("BOB","068","Boliviano","玻利维亚玻利维亚诺","53"),

    BOV("BOV","984","Bolivian Mvdol","玻利维亚 mvdol","54"),

    BSD("BSD","044","Bahamian dollar","巴哈马元","55"),

    BTN("BTN","064","Bhutanese ngultrum","不丹努扎姆","56"),

    BWP("BWP","072","Botswana pula","博茨瓦纳普拉","57"),

    BYR("BYR","974","Belarusian ruble","白俄罗斯卢布","58"),

    BZD("BZD","084","Belize dollar","伯利兹元","59"),

    CDF("CDF","976","Congolese franc","刚果民主共和国刚果法郎","60"),

    CHE("CHE","947","WIR Euro (complementary currency)","CHE","61"),

    CHW("CHW","948","WIR Franc (complementary currency)","CHW","62"),

    CLF("CLF","990","Unidad de Fomento (funds code)","智利比索（可兑换的基金）","63"),

    CLP("CLP","152","Chilean peso","智利比索","64"),

    COP("COP","170","Colombian peso","哥伦比亚比索","65"),

    COU("COU","970","Unidad de Valor Real (UVR)"," 哥伦比亚unidad de valor real","66"),

    CRC("CRC","188","Costa Rican colon","哥斯达黎加科朗","67"),

    CUC("CUC","931","Cuban convertible peso","塞尔维亚第纳尔","68"),

    CUP("CUP","192","Cuban peso","古巴比索","69"),

    CVE("CVE","132","Cape Verde escudo","佛得角埃斯库多","70"),

    DJF("DJF","262","Djiboutian franc","吉布提法郎","71"),

    DOP("DOP","214","Dominican peso","多米尼加比索","72"),

    DZD("DZD","012","Algerian dinar","阿尔及利亚第纳尔","73"),

    EGP("EGP","818","Egyptian pound","埃及镑","74"),

    ERN("ERN","232","Eritrean nakfa","厄立特里亚纳克法","75"),

    ETB("ETB","230","Ethiopian birr","埃塞俄比亚比尔","76"),

    FJD("FJD","242","Fiji dollar","斐济元","77"),

    FKP("FKP","238","Falkland Islands pound","福克兰镑","78"),

    GEL("GEL","981","Georgian lari","格鲁吉亚拉里","79"),

    GHS("GHS","936","Ghanaian cedi","加纳塞地","80"),

    GIP("GIP","292","Gibraltar pound","直布罗陀镑","81"),

    GMD("GMD","270","Gambian dalasi","冈比亚达拉西","82"),

    GNF("GNF","324","Guinean franc","几内亚法郎","83"),

    GTQ("GTQ","320","Guatemalan quetzal","危地马拉格查尔","84"),

    GYD("GYD","328","Guyanese dollar","圭亚那元","85"),

    HNL("HNL","340","Honduran lempira","洪都拉斯伦皮拉","86"),

    HRK("HRK","191","Croatian kuna","克罗地亚库纳","87"),

    HTG("HTG","332","Haitian gourde","海地古德","88"),

    IDR("IDR","360","Indonesian rupiah","印度尼西亚盾/卢比","89"),

    IQD("IQD","368","Iraqi dinar","伊拉克第纳尔","90"),

    IRR("IRR","364","Iranian rial","伊朗里亚尔","91"),

    ISK("ISK","352","Icelandic króna","冰岛克朗","92"),

    JMD("JMD","388","Jamaican dollar","牙买加元","93"),

    KES("KES","404","Kenyan shilling","肯尼亚先令","94"),

    KGS("KGS","417","Kyrgyzstani som","吉尔吉斯斯坦索姆","95"),

    KHR("KHR","116","Cambodian riel","柬埔寨瑞尔","96"),

    KMF("KMF","174","Comoro franc","科摩罗法郎","97"),

    KPW("KPW","408","North Korean won","朝鲜圆","98"),

    KYD("KYD","136","Cayman Islands dollar","开曼群岛元","99"),

    KZT("KZT","398","Kazakhstani tenge","哈萨克斯坦坚戈","100"),

    LAK("LAK","418","Lao kip","老挝基普","101"),

    LBP("LBP","422","Lebanese pound","黎巴嫩镑","102"),

    LKR("LKR","144","Sri Lankan rupee","斯里兰卡卢比","103"),

    LRD("LRD","430","Liberian dollar","利比里亚元","104"),

    LSL("LSL","426","Lesotho loti","莱索托洛蒂","105"),

    LYD("LYD","434","Libyan dinar","利比亚第纳尔","106"),

    MAD("MAD","504","Moroccan dirham","摩洛哥迪拉姆","107"),

    MDL("MDL","498","Moldovan leu","摩尔多瓦列伊","108"),

    MGA("MGA","969","Malagasy ariary","马达加斯加阿里亚里","109"),

    MKD("MKD","807","Macedonian denar","前南马其顿代纳尔","110"),

    MMK("MMK","104","Myanmar kyat","缅甸元","111"),

    MNT("MNT","496","Mongolian tugrik","蒙古图格里克","112"),

    MRO("MRO","478","Mauritanian ouguiya","毛里塔尼亚乌吉亚","113"),

    MUR("MUR","480","Mauritian rupee","毛里求斯卢比","114"),

    MVR("MVR","462","Maldivian rufiyaa","马尔代夫拉菲亚","115"),

    MWK("MWK","454","Malawian kwacha","马拉维克瓦查","116"),

    MXV("MXV","979","Mexican Unidad de Inversion(UDI) (funds code)","墨西哥Unidad de Inversion (UDI）（基金）","117"),

    MZN("MZN","943","Mozambican metical","莫桑比克美提卡","118"),

    NAD("NAD","516","Namibian dollar","纳米比亚元","119"),

    NGN("NGN","566","Nigerian naira","尼日利亚奈拉","120"),

    NIO("NIO","558","Nicaraguan córdoba","尼加拉瓜科多巴","121"),

    NPR("NPR","524","Nepalese rupee","尼泊尔卢比","122"),

    PAB("PAB","590","Panamanian balboa","巴拿马巴波亚","123"),

    PEN("PEN","604","Peruvian nuevo sol","秘鲁新索尔","124"),

    PGK("PGK","598","Papua New Guinean kina","巴布亚新几内亚基那","125"),

    PKR("PKR","586","Pakistani rupee","巴基斯坦卢比","126"),

    PYG("PYG","600","Paraguayan guaraní","巴拉圭瓜拉尼","127"),

    RON("RON","946","Romanian new leu","罗马尼亚列伊","128"),

    RSD("RSD","941","Serbian dinar","塞尔维亚第纳尔","129"),

    RWF("RWF","646","Rwandan franc","卢旺达法郎","130"),

    SBD("SBD","090","Solomon Islands dollar","所罗门群岛元","131"),

    SCR("SCR","690","Seychelles rupee","塞舌尔卢比","132"),

    SDG("SDG","938","Sudanese pound","苏丹镑","133"),

    SHP("SHP","654","Saint Helena pound","圣赫勒拿镑","134"),

    SLL("SLL","694","Sierra Leonean leone","塞拉利昂利昂","135"),

    SOS("SOS","706","Somali shilling","索马里先令","136"),

    SRD("SRD","968","Surinamese dollar","苏里南元","137"),

    SSP("SSP","728","South Sudanese pound","南苏丹镑","138"),

    STD("STD","678","São Tomé and Príncipe dobra","圣多美和普林西比多布拉","139"),

    SYP("SYP","760","Syrian pound","叙利亚镑","140"),

    SZL("SZL","748","Swazi lilangeni","斯威士兰里兰吉尼","141"),

    TJS("TJS","972","Tajikistani somoni","塔吉克斯坦索莫尼","142"),

    TMT("TMT","934","Turkmenistani manat","土库曼斯坦马纳特","143"),

    TND("TND","788","Tunisian dinar","突尼斯第纳尔","144"),

    TOP("TOP","776","Tongan paʻanga","汤加潘加","145"),

    TTD("TTD","780","Trinidad and Tobago dollar","特立尼达和多巴哥元","146"),

    TZS("TZS","834","Tanzanian shilling","坦桑尼亚先令","147"),

    UAH("UAH","980","Ukrainian hryvnia","乌克兰格里夫尼亚","148"),

    UGX("UGX","800","Ugandan shilling","乌干达先令","149"),

    USN("USN","997","United States dollar (next day) (funds code)","美元（次日）（资金）（第二天）（基金）","150"),

    USS("USS","998","United States dollar (same day) (funds code)","美元（当日）（资金）（同一天）（基金","151"),

    UYI("UYI","940","Uruguay Peso en Unidades Indexadas (URUIURUI) (funds code)","UYI","152"),

    UYU("UYU","858","Uruguayan peso","乌拉圭比索","153"),

    UZS("UZS","860","Uzbekistan som","乌兹别克斯坦苏姆","154"),

    VEF("VEF","937","Venezuelan bolívar","委内瑞拉玻利瓦尔","155"),

    VND("VND","704","Vietnamese dong","越南盾","156"),

    VUV("VUV","548","Vanuatu vatu","瓦努阿图瓦图","157"),

    WST("WST","882","Samoan tala","萨摩亚塔拉","158"),

    XAF("XAF","950","CFA franc BEAC","中非金融合作法郎","159"),

    XAG("XAG","961","Silver (one troy ounce)","白银","160"),

    XAU("XAU","959","Gold (one troy ounce)","黄金","161"),

    XBA("XBA","955","European Composite Unit(EURCO) (bond market unit)","欧洲复合单位 (EURCO) / 欧洲混合单位（债券市场单位）","162"),

    XBB("XBB","956","European Monetary Unit(E.M.U.-6) (bond market unit)","欧洲货币联盟(E.M.U.-6）（债券市场单位）","163"),

    XBC("XBC","957","European Unit of Account 9(E.U.A.-9) (bond market unit)","9号帐户的欧洲单位（债券市场单位）","164"),

    XBD("XBD","958","European Unit of Account 17(E.U.A.-17) (bond market unit)","17号帐户的欧洲单位（债券市场单位）","165"),

    XCD("XCD","951","East Caribbean dollar","东加勒比元","166"),

    XDR("XDR","960","Special drawing rights","特别提款权","167"),

    XFU("XFU","Nil","UIC franc(special settlement currency)","UIC法郎（特殊协定货币）","168"),

    XOF("XOF","952","CFA franc BCEAO","非洲金融共同体法郎（西非法郎）","169"),

    XPD("XPD","964","Palladium (onetroy ounce)","钯","170"),

    XPF("XPF","953","CFP franc (franc Pacifique)","太平洋法郎（CFP法郎）","171"),

    XPT("XPT","962","Platinum (onetroy ounce)","铂","172"),

    XSU("XSU","994","SUCRE","XSU","173"),

    XTS("XTS","963","Code reserved for testing purposes","为测试保留的代码","174"),

    XUA("XUA","965","ADB Unit of Account","XUA","175"),

    XXX("XXX","999","No currency","没有货币的交换","176"),

    YER("YER","886","Yemeni rial","也门里亚尔","177"),

    ZMW("ZMW","967","Zambian kwacha","赞比亚克瓦查","178"),

    ZWL("ZWL","932","Zimbabwean dollar","津巴布韦元","179"),
    ;

    private final String code;
    private final String id;
    private final String description;
    private final String description_zh;
    private final String accountCode;
    
    /**
     * 创建一个新的实例 CurrencyEnum.
     * 
     * @param code
     * @param description
     * @param description_zh
     */
    private CurrencyEnum(String code, String id, String description, String description_zh,String accountCode) {
        this.code = code;
        this.id = id;
        this.description = description;
        this.description_zh = description_zh;
        this.accountCode = accountCode;
    }

    /**
     * code
     * 
     * @return the code
     * @since 1.0.0
     */

    public String getCode() {
        return code;
    }

    /**
     * description
     * 
     * @return the description
     * @since 1.0.0
     */

    public String getDescription() {
        return description;
    }

    /**
     * description_zh
     * 
     * @return the description_zh
     * @since 1.0.0
     */

    public String getDescription_zh() {
        return description_zh;
    }

    public String getAccountCode(){
    	return accountCode;
    }
    
    /**
     * 
     * 通过code获取枚举
     * 
     * @param code
     * @return CurrencyEnum
     * @exception
     * @since 1.0.0
     */
    public static CurrencyEnum getByCode(String code) {
        for (CurrencyEnum currencyEnum : values()) {
            if (currencyEnum.getCode().equals(code)) {
                return currencyEnum;
            }
        }
        return null;
    }

    /**
     * 
     * 通过id获取枚举
     * 
     * @param id
     * @return
     * @since 1.0.0
     */
    public static CurrencyEnum getById(String id) {
        for (CurrencyEnum currencyEnum : values()) {
            if (currencyEnum.getId().equals(id)) {
                return currencyEnum;
            }
        }
        return null;
    }
    
    public static CurrencyEnum getByAccountCode(String accountCode){
    	for (CurrencyEnum currencyEnum : values()) {
            if (currencyEnum.getAccountCode().equals(accountCode)) {
                return currencyEnum;
            }
        }
        return null;
    }

    /**
     * 
     * 通过id获取枚举
     * 
     * @param id
     * @return
     * @since 1.0.0
     */
    public static CurrencyEnum getByCurrency(Currency currency) {
        return currency == null ? null : getByCode(currency.getCurrencyCode());
    }

    public static CurrencyEnum getByMoney(Money money) {
        return money == null ? null : getByCode(money.getCurrencyCode());
    }

    /**
     * 
     * getId(currency id, 数字表达形式)
     * 
     * @return
     * @since 1.0.0
     */
    public String getId() {
        return id;
    }

}
