package com.sxt.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import com.sxt.inter.dto.FormConvertToVo;
import com.sxt.inter.dto.InvestRecordDto;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.inter.dto.MemberMoneyDto;
import com.sxt.models.BorrowInvestor;
import com.sxt.models.CashAccount;
import com.sxt.models.ExperienceProduct;
import com.sxt.models.LdYingxiangProduct;
import com.sxt.models.MemberBorrow;
import com.sxt.models.Members;
import com.sxt.models.OffProductTransaction;
import com.sxt.models.Questionnaire;
import com.sxt.models.SiProduct;
import com.sxt.page.util.Page;
import com.sxt.page.util.PageUtils;
import com.sxt.service.Base64Encrypt;
import com.sxt.service.BorrowInvestorService;
import com.sxt.service.BorrowPlanService;
import com.sxt.service.CashService;
import com.sxt.service.LdParameterService;
import com.sxt.service.MemberBorrowService;
import com.sxt.service.MemberExperienceGoldDetailService;
import com.sxt.service.MemberInfoService;
import com.sxt.service.MemberMoneyDetailService;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MemberService;
import com.sxt.service.MemberWithdrawService;
import com.sxt.service.MessageService;
import com.sxt.service.QuestionnaireService;
import com.sxt.service.RepaymentDetailService;
import com.sxt.service.RepaymentRecordService;
import com.sxt.service.RewardRecordService;
import com.sxt.service.product.CiProductService;
import com.sxt.service.product.ExperienceProductService;
import com.sxt.service.product.SiProductDetailService;
import com.sxt.service.product.SiProductService;
import com.sxt.service.product.YingXiangProductService;
import com.sxt.util.DateUtil;
import com.sxt.util.Money;
import com.sxt.util.SHAUtil;

@Controller
@RequestMapping("borrowinvest")
public class BorrowInvestorController extends AbstractGeneralController
{
	@Autowired
	private BorrowInvestorService borrowInvestorService;
	@Autowired
	private CiProductService ciProductService;
	@Autowired
	private SiProductService siProductService;
	@Autowired
	private RepaymentRecordService repaymentRecordService;
	@Autowired
	private MemberMoneyService memberMoneyService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private SiProductDetailService siProductDetailService;
	@Autowired
	private MemberMoneyDetailService memberMoneyDetailService;
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private MemberBorrowService memberBorrowService;
	@Autowired
	private BorrowPlanService borrowPlanService;
	@Autowired
	private RepaymentDetailService repaymentDetailService;
	@Autowired
	private RewardRecordService rewardRecordService;
	@Autowired
	private Base64Encrypt base64Encrypt;
	Map<String, Object> map = new HashMap<String, Object>();
	@Autowired
	private MessageService messageService;
	@Autowired
	private MemberExperienceGoldDetailService memberExperienceGoldDetailService;
	@Autowired
	private ExperienceProductService experienceProductService;
	@Autowired
	private QuestionnaireService questionnaireService;

	@Autowired
	private MemberWithdrawService  memberWithdrawService;
	@Autowired
	private CashService cashService;
	@Autowired
	private YingXiangProductService yingXiangProductService;
	
	@Autowired
	private LdParameterService  ldParameterService;
	
	/**
	 * @throws ParseException 
	 * @throws IOException 
	 * 
	 */
	@RequestMapping("queryPaymentTime.htm")
	@ResponseBody
	public String queryPaymentTime(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("monthId") String monthId, ModelMap map) throws ParseException, IOException{
		LocalUserDto lud = super.getLocalUser(request);
		if(lud == null){
			return JSONObject.toJSONString(map.addAttribute("tag", 0));
		}
        response.setContentType("text/json"); 
        response.setCharacterEncoding("UTF-8");  
		monthId = monthId + "-01";
		Date repaymentTime = DateUtil.string2Date(monthId) ;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(repaymentTime);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("firstDate", monthId);
		param.put("investorUid", lud.getUid());
		param.put("countDay", calendar.getActualMaximum(Calendar.DATE));
		map.addAttribute("result", borrowPlanService.queryPaymentTime(param));

		response.setCharacterEncoding("utf-8");
	    response.getWriter().write(JSONObject.toJSONString(map));
	    return null;
	}
	
	/**
	 * experienceProductService
	 * 
	 * 我 的 账 户
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("toinvest.htm")
	public ModelAndView fQueryMoneyInterestByuid(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/member/accounts");
		//年份
		Integer minPaymentYear = Integer.parseInt(ldParameterService.getParameterByName("minPaymentYear", "2014").getValue());
		Integer maxPaymentYear = Integer.parseInt(ldParameterService.getParameterByName("maxPaymentYear", "2020").getValue());
		mav.addObject("minPaymentYear", minPaymentYear);
		mav.addObject("maxPaymentYear", maxPaymentYear);
		
		Map<String, Object> finvestormap = new HashMap<String, Object>();
		Map<String, Object> fborrowermap = new HashMap<String, Object>();
		LocalUserDto lud = super.getLocalUser(request);
		MemberMoneyDto mem = null;
		if (lud != null){
			//下个还款日
			mav.addObject("nextPaymentTime", borrowPlanService.queryNextPaymentTime(lud.getUid()));
			
			if (lud.getUid() != 0){
				 mem = memberMoneyService.queryMemberMoney(lud.getUid());
				if (mem != null){
					mav.addObject("mem", mem);
					super.refreshSessionValue(memberMoneyService, request);
				}
			}
			/**
			 * 开始判断是投资人还是借款人
			 */
			// 登录上的用户可能是投资人也可能是借款人计算从这里开始begin
			List<MemberBorrow> memberborrowlist = memberBorrowService.fqueryborrowlist(lud.getUid());
			request.setAttribute("memberborrowlist", memberborrowlist);// 我的借款
			List<SiProduct> siprolist = siProductService.fQueryListSiProByUid(lud.getUid());// 用户Id
			List<BorrowInvestor> borrowinveslist = borrowInvestorService.fQueryisinvest(lud.getUid());
			if (siprolist.size() >= 1)	{// 借款人
				List<BorrowInvestor> borrowinvestorList = borrowInvestorService.fQueryisinvest(lud.getUid());
				if (borrowinvestorList.size() >= 1)	{// 投资人==推算出 既是借款人又是投资人
					try	{
						finvestormap = finvestor(lud.getUid()); // 先是投资人
						
						fborrowermap = fborrower(lud.getUid());// 借款人
					} catch (Exception e){
						e.printStackTrace();
					}
				} else{// 只是借款人
					try	{
						fborrowermap = fborrower(lud.getUid());
					} catch (Exception e){
						e.printStackTrace();
					}
				}
			} else if (borrowinveslist.size() >= 1)	{
				try	{
					finvestormap = finvestor(lud.getUid());
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			
			BigDecimal investFreezeMoney =null;
			BigDecimal countWithdrawFreezeMoney	= memberWithdrawService.queryCountWithdrawFreezeMoney(lud.getUid());//提现冻结
			BigDecimal freezeMoney= mem.getMoneyFreeze();//总共的冻结金额
			if(freezeMoney == null){
				investFreezeMoney = BigDecimal.ZERO;
			}else{
				investFreezeMoney = freezeMoney.subtract(countWithdrawFreezeMoney);//冻结金额
			}
			mav.addObject("countWithdrawFreezeMoney",countWithdrawFreezeMoney);//提现冻结
			mav.addObject("investFreezeMoney",investFreezeMoney);//投资冻结
			mav.addObject("finvestormap", finvestormap);
			mav.addObject("fborrowermap", fborrowermap);
			// 体验金总额
			BigDecimal b = new BigDecimal(0.00);
			MemberMoneyDto mmd = memberMoneyService.queryMemberMoney(lud.getUid());
			if (mmd != null){
				mav.addObject("mmd", mmd);
			} else{
				mav.addObject("mmd", b);
			}
			List<ExperienceProduct> proidlist = experienceProductService.fQueryProid();
			
			Map<String,Object> param=new HashMap<String, Object>();
			param.put("uid",lud.getUid());
			List<String> ids = new ArrayList<String>();
			Float borrowInterestRate = 0.05f;
			Integer borrowDayDuration = 7;
			for (ExperienceProduct product : proidlist)	{
				ids.add(product.getProductId());
				param.put("proid",product.getProductId());
				borrowInterestRate = product.getBorrowInterestRate();
				borrowDayDuration = product.getBorrowDayDuration ();
			}
			/*BigDecimal investgold=borrowInvestorService.queryExperienceGoldByProid(param);
			if (investgold != null)	{
				mav.addObject("investgold", investgold);
			} else{
				mav.addObject("investgold", b);
			}*/
			// String[] ids = proidlist.toArray(new String[proidlist.size()]);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("proidlist", ids.toArray(new String[ids.size()]));
			map.put("uid", lud.getUid());
			map.put("status", 1);
			BigDecimal waitinterest = repaymentDetailService.fQueryRepayMoneyState1(map);// 待收利息
			BigDecimal investgold = memberExperienceGoldDetailService.queryInvestgoldByUid(lud.getUid());//体验中的金额
			mav.addObject("investgold", investgold);
			if (waitinterest != null){
				mav.addObject("waitinterest", waitinterest);
			} else{
				mav.addObject("waitinterest", b);
			}
			map.remove("status");
			map.put("status", 2);
			BigDecimal hasbeeninterest = repaymentDetailService.fQueryRepayMoneyState1(map);// 已获利息
			if (hasbeeninterest != null){
				mav.addObject("hasbeeninterest", hasbeeninterest);
			} else{
				mav.addObject("hasbeeninterest", b);
			}
			/**
			 * 结束
			 */
		}
		return mav;
	}

	/*
	 * 投资人
	 */
	public Map<String, Object> finvestor(int uid){
		Map<String, Object> mav = new HashMap<String, Object>();
		BigDecimal big = new BigDecimal(0.0);
		Map<String, Object> map = repaymentDetailService.fQueryMoneyInterestBybid(uid);
		MemberMoneyDto collectMoneyDto = memberMoneyService.queryMemberMoney(uid);
		CashAccount cashAccount = cashService.getCashAccountByUid(uid);
		BigDecimal collectMoney = BigDecimal.ZERO;
		BigDecimal cashMoney = BigDecimal.ZERO;
		if(collectMoneyDto != null) {
			collectMoney = collectMoneyDto.getMoneyCollect();
		}
		if(cashAccount != null) {
			collectMoney = moneyProcess(collectMoney,cashAccount.getAccountMoney(),"+");
			collectMoney = moneyProcess(collectMoney,cashAccount.getCashFreeze(),"-");
			cashMoney = moneyProcess(cashMoney,cashAccount.getAccountMoney(),"+");
			cashMoney = moneyProcess(cashMoney,cashAccount.getCashFreeze(),"-");
		}
		mav.put("collectMoney", collectMoney);//待收金额
		mav.put("cashMoney", cashMoney);//活期宝账户
		Money amount1;
		Money amount2;
		try{
			if (map == null || map.get("investor_capital") == null|| map.get("investor_capital") == "")	{
				amount1 = new Money(big, Currency.getInstance("CNY"));
			} else {
				amount1 = new Money(new BigDecimal(map.get("investor_capital")
						.toString()), Currency.getInstance("CNY"));
			}
			if (map == null || map.get("investor_interest") == null) {
				amount2 = new Money(big, Currency.getInstance("CNY"));
			} else {
				amount2 = new Money(new BigDecimal(map.get("investor_interest").toString()), Currency.getInstance("CNY"));
			}
			Money allamount = amount1.add(amount2);
			mav.put("amount1", amount1.getAmount());// 待收本金
			mav.put("amount2", amount2.getAmount());// 待收利息
			mav.put("allamount", allamount.getAmount());
		
		/*BigDecimal countFreezeMoney =  borrowInvestorService.queryCountFreezeMoney(uid);	//投资冻结
		if(countFreezeMoney.compareTo(BigDecimal.ZERO) == 0) {
			
		}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	/*
	 * 借款人
	 */
	public Map<String, Object> fborrower(int uid) {
		Map<String, Object> mav = new HashMap<String, Object>();
		Money m1;
		Money m2;
		BigDecimal b = new BigDecimal(0.0);
		map = borrowPlanService.fqueryborrowmoney(uid);
		try	{
			if (map == null || map.get("investor_capital") == null)	{
				m1 = new Money(b, Currency.getInstance("CNY"));
			} else {
				m1 = new Money(new BigDecimal(map.get("investor_capital")
						.toString()), Currency.getInstance("CNY"));
			}
			if (map == null || map.get("investor_interest") == null) {
				m2 = new Money(b, Currency.getInstance("CNY"));
			} else {
				m2 = new Money(new BigDecimal(map.get("investor_interest")
						.toString()), Currency.getInstance("CNY"));
			}
			Money allborrow = m1.add(m2);
			mav.put("m1", m1.getAmount());
			mav.put("m2", m2.getAmount());
			mav.put("allborrow", allborrow.getAmount());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	
	/* ajax 支付密码 请求
	 * 
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */

	@RequestMapping("paypwd.htm")
	@ResponseBody
	public String checkPayPwd(HttpServletRequest request, @RequestParam("tradepwd") String tradepwd)
			throws NoSuchAlgorithmException, UnsupportedEncodingException{
		LocalUserDto lud = super.getLocalUser(request);
		if (lud == null){
			return "null";
		}
		if (tradepwd == null || tradepwd.equals("")){
			return "isnull";
		}
		String paypass = SHAUtil.encryptSHA1(base64Encrypt.encrypt(tradepwd));// 加密后的交易密码
		Members member = memberService.fQueryNameByUid(lud.getUid());
		String pass = member.getPayPass();// 支付密码
		if (pass == null || pass.equals("") || pass.equals("0")){
			return "isno";
		}
		if (paypass.equals(pass)){
			return "yes";
		}
		return "no";
	}
	
	@RequestMapping("fallproductinvest.htm")
	public ModelAndView queryProduct(HttpServletRequest request, @RequestParam("typeType") int typeType){
		ModelAndView mav = new ModelAndView("/member/investment");
//		mav.addObject("cipage", queryCiPro(request));
		mav.addObject("sipage", querySiPro(request));
		mav.addObject("expage", queryExperiencePro(request));
		mav.addObject("yxpage", queryYingXiangPro(request));
		mav.addObject("timeType",0);
		mav.addObject("typeType",typeType==0?0:typeType);
		mav.addObject("type",0);
		return mav;
	}

	/** 涨中宝的查询 **/
	@RequestMapping("querycirecord.htm")
	public ModelAndView queryInvestRecord(HttpServletRequest request,@RequestParam Map<String, Object> map){
		ModelAndView mav = new ModelAndView("/member/queryCiList");
		LocalUserDto lud = super.getLocalUser(request);
		Page<InvestRecordDto> cipage = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToPage(cipage);
		if (lud.getUid() != 0){
			para.put("uid", lud.getUid());
			para.put("tableName", "ld_ci_product");
			para.put("borrowStatus", map.get("type"));
			para.put("productIds", null);

			if (map.get("timeType").equals("2")){
				para.put("weekend", map.get("timeType"));
			} else if (map.get("timeType").equals("3")){
				para.put("month", map.get("timeType"));
			} else if (map.get("timeType").equals("4")){
				para.put("otherMonth", map.get("timeType"));
			}
			int count = borrowInvestorService.fqueryInvestRecodeCountByMap(para);
			if(count>0){
				List<InvestRecordDto> investrecord = borrowInvestorService.fqueryInvestRecodeByMap(para);
				cipage.setResult(investrecord);
				cipage.setTotalCount(count);
			}
			
			mav.addObject("cipage", cipage);
			mav.addObject("timeType", map.get("timeType"));
			mav.addObject("typeType", map.get("typeType"));
			mav.addObject("type",map.get("type"));
		}
		return mav;
	}

	/** 散标的查询 **/
	@RequestMapping("querysirecord.htm")
	public ModelAndView querysirecord(HttpServletRequest request,@RequestParam Map<String, Object> map){
		ModelAndView mav = new ModelAndView("/member/querySiNiList");
		LocalUserDto lud=super.getLocalUser(request);
		Page<InvestRecordDto> sipage = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToPage(sipage);
		if (lud.getUid() != 0){
			para.put("uid", lud.getUid());
			para.put("borrowStatus",map.get("type"));
			para.put("productIds", null);
			if (map.get("timeType").equals("2")){
				para.put("weekend", map.get("timeType"));
			} else if (map.get("timeType").equals("3")){
				para.put("month", map.get("timeType"));
			} else if (map.get("timeType").equals("4")){
				para.put("otherMonth", map.get("timeType"));
			}
			int count = borrowInvestorService.getSiAndNewProductInfoCount(para);
			List<InvestRecordDto> investrecord = null;
			if(count>0){
				investrecord = borrowInvestorService.getSiAndNewProductInfo(para);
			}
			sipage.setTotalCount(count);
			sipage.setResult(investrecord);
			mav.addObject("sipage", sipage);
			mav.addObject("timeType", map.get("timeType"));
			mav.addObject("typeType", map.get("typeType"));
			mav.addObject("type",map.get("type"));
		}
		return mav;
	}
	
	/** 盈享的查询 **/
	@RequestMapping("queryyxrecord.htm")
	public ModelAndView queryyxrecord(HttpServletRequest request, @RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("/member/queryYxNiList");
		LocalUserDto lud = super.getLocalUser(request);
		Page<InvestRecordDto> yxpage = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToPage(yxpage);
		if (lud.getUid()!= 0){
			para.put("uid", lud.getUid());
			para.put("tableName", "ld_yingxiang_product");
			para.put("borrowStatus", map.get("type"));
			para.put("productIds", null);

			if (map.get("timeType").equals("2")){
				para.put("weekend", map.get("timeType"));
			} else if (map.get("timeType").equals("3")){
				para.put("month", map.get("timeType"));
			} else if (map.get("timeType").equals("4")){
				para.put("otherMonth", map.get("timeType"));
			}
			List<InvestRecordDto> investrecord = borrowInvestorService.fqueryYxInvestRecodeByMap(para);
			if(investrecord != null) {
				Map<String, Object> exMap = new HashMap<String, Object>();
				for(InvestRecordDto dto:investrecord) {
					exMap.put("systemTraceNo", dto.getSystemTraceNo());
					exMap.put("uid",lud.getUid());
					LdYingxiangProduct yingXiangProduct = new LdYingxiangProduct();
					map.put("systemTraceNo", dto.getSystemTraceNo());
					map.put("uid",lud.getUid());
					yingXiangProduct.setProductId(dto.getProductId());
					yingXiangProduct = yingXiangProductService.queryLdYingxiangProductByCondition(yingXiangProduct);
					dto.setLastTime(yingXiangProduct.getLastTime());
				}
			}
			int count = borrowInvestorService.fqueryInvestRecodeCountByMap(para);
			yxpage.setResult(investrecord);
			yxpage.setTotalCount(count);
			mav.addObject("yxpage", yxpage);
			mav.addObject("timeType", map.get("timeType"));
			mav.addObject("typeType", map.get("typeType"));
			mav.addObject("type",map.get("type"));
		}
		return mav;
	}

	/** 体验标的查询 **/
	@RequestMapping("queryexrecord.htm")
	public ModelAndView queryexrecord(HttpServletRequest request,@RequestParam Map<String, Object> map){
		ModelAndView mav = new ModelAndView("/member/queryExSiList");
		LocalUserDto lud = super.getLocalUser(request);
		Page<InvestRecordDto> expage = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToPage(expage);
		if (lud.getUid()!= 0){
			para.put("uid", lud.getUid());
			para.put("tableName", "ld_experience_product");
			para.put("borrowStatus", map.get("type"));
			para.put("productIds", null);

			if (map.get("timeType").equals("2")){
				para.put("weekend", map.get("timeType"));
			} else if (map.get("timeType").equals("3")){
				para.put("month", map.get("timeType"));
			} else if (map.get("timeType").equals("4")){
				para.put("otherMonth", map.get("timeType"));
			}
			List<InvestRecordDto> investrecord = borrowInvestorService.fqueryExInvestRecodeByMap(para);
			if(investrecord != null) {
				Map<String, Object> exMap = new HashMap<String, Object>();
				for(InvestRecordDto dto:investrecord) {
					exMap.put("systemTraceNo", dto.getSystemTraceNo());
					exMap.put("uid",lud.getUid());
					InvestRecordDto goldDto = borrowInvestorService.getExperGoldByNoAndId(exMap);
					dto.setAffectExperienceGold(goldDto.getAffectExperienceGold());
				}
			}
			int count = borrowInvestorService.fqueryInvestRecodeCountByMap(para);
			expage.setResult(investrecord);
			expage.setTotalCount(count);
			mav.addObject("expage", expage);
			mav.addObject("timeType", map.get("timeType"));
			mav.addObject("typeType", map.get("typeType"));
			mav.addObject("type",map.get("type"));
		}
		return mav;
	}

	/**
	 * 涨中宝
	 */
	public Page<InvestRecordDto> queryCiPro(HttpServletRequest request) {
		Page<InvestRecordDto> page = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToPage(page);
		LocalUserDto lud = super.getLocalUser(request);
		if (lud != null){
			para.put("uid", lud.getUid());
			para.put("tableName", "ld_ci_product");
			para.put("borrowStatus",0);
			para.put("productIds", null);
			int count = borrowInvestorService.fqueryInvestRecodeCountByMap(para);
			if(count>0){
				List<InvestRecordDto> investrecord = borrowInvestorService.fqueryInvestRecodeByMap(para);
				/*for (InvestRecordDto investRecordDto : investrecord) {
				BigDecimal proval=rewardRecordService.queryProval(investRecordDto.getSystemTraceNo());
				investRecordDto.setProValue(proval);
				}*/
				page.setTotalCount(count);
				page.setResult(investrecord);
			}
		}
		return page;
	}

	/**
	 * 散标
	 * 
	 * @return
	 */
	public Page<InvestRecordDto> querySiPro(HttpServletRequest request)	{
		Page<InvestRecordDto> sipage = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToPage(sipage);
		LocalUserDto lud = super.getLocalUser(request);
		if(lud.getUid()!=0){
		para.put("uid", lud.getUid());
		para.put("tableName", "ld_si_product");
		para.put("borrowStatus", 0);
		para.put("productIds", null);
		int count = borrowInvestorService.fqueryInvestRecodeCountByMap(para);
		List<InvestRecordDto> investrecord = null;
		if(count>0){
		   investrecord = borrowInvestorService.fqueryInvestRecodeByMap(para);
		  /* for (InvestRecordDto investRecordDto : investrecord) {
				BigDecimal proval=rewardRecordService.queryProval(investRecordDto.getSystemTraceNo());
				investRecordDto.setProValue(proval);
				}*/
		}
		//新手标
		para.remove("tableName");
		para.put("tableName","ld_newhand_product");
		int newcount = borrowInvestorService.fqueryInvestRecodeCountByMap(para);
		if(newcount>0){
			List<InvestRecordDto> newHandrecord = borrowInvestorService.fqueryNewInvestRecodeByMap(para);
			if(investrecord==null){
				investrecord = newHandrecord;
			}else{
				investrecord.addAll(newHandrecord);
			}
			count=count+newcount;
		}
		//私募基金
		para.remove("tableName");
		para.put("tableName","ld_pe_product");
		int pecount = borrowInvestorService.fqueryInvestRecodeCountByMap(para);
		if(pecount>0){
			List<InvestRecordDto> peRecord = borrowInvestorService.fqueryInvestRecodeByMap(para);
			if(investrecord==null){
				investrecord = peRecord;
			}else{
				investrecord.addAll(peRecord);
			}
			count=count+pecount;
		}
		//按时间降序排列
		if(investrecord != null) {
			Collections.sort(investrecord, new Comparator() {
				public int compare(Object o1, Object o2) {
					InvestRecordDto dto1 = (InvestRecordDto)o1;
					InvestRecordDto dto2 = (InvestRecordDto)o2;
					if(dto1.getCreateTime().compareTo(dto2.getCreateTime()) > 0) {
						return -1;
					}else if(dto1.getCreateTime().compareTo(dto2.getCreateTime()) < 0) {
						return 1;
					}else {
						return 0;
					}
				}
			});
		}
		sipage.setTotalCount(count);
		sipage.setResult(investrecord);
		}
		return sipage;
	}
	/**
	 * 体验标
	 * 
	 * @return
	 */
	public Page<InvestRecordDto> queryExperiencePro(HttpServletRequest request){
		Page<InvestRecordDto> expage = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToPage(expage);
		LocalUserDto lud = super.getLocalUser(request);
		if(lud.getUid()!=0){
		para.put("uid", lud.getUid());
		para.put("tableName", "ld_experience_product");
		para.put("borrowStatus", 0);
		para.put("productIds", null);
		List<InvestRecordDto> investrecord = borrowInvestorService.fqueryExInvestRecodeByMap(para);
		if(investrecord != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			for(InvestRecordDto dto:investrecord) {
				map.put("systemTraceNo", dto.getSystemTraceNo());
				map.put("uid",lud.getUid());
				InvestRecordDto goldDto = borrowInvestorService.getExperGoldByNoAndId(map);
				dto.setAffectExperienceGold(goldDto.getAffectExperienceGold());
			}
		}
		
		int count = borrowInvestorService.fqueryInvestRecodeCountByMap(para);
		expage.setTotalCount(count);
		expage.setResult(investrecord);
		}
		return expage;
	}
	
	/**
	 * 盈享理财
	 * @param request
	 * @return
	 */
	public Page<InvestRecordDto> queryYingXiangPro(HttpServletRequest request){
		Page<InvestRecordDto> yxpage = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToPage(yxpage);
		LocalUserDto lud = super.getLocalUser(request);
		if(lud.getUid()!=0){
		para.put("uid", lud.getUid());
		para.put("tableName", "ld_yingxiang_product");
		para.put("borrowStatus", 0);
		para.put("productIds", null);
		List<InvestRecordDto> investrecord = borrowInvestorService.fqueryYxInvestRecodeByMap(para);
	
		if(investrecord != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			for(InvestRecordDto dto:investrecord) {
				LdYingxiangProduct yingXiangProduct = new LdYingxiangProduct();
				map.put("systemTraceNo", dto.getSystemTraceNo());
				map.put("uid",lud.getUid());
				yingXiangProduct.setProductId(dto.getProductId());
				yingXiangProduct = yingXiangProductService.queryLdYingxiangProductByCondition(yingXiangProduct);
				dto.setLastTime(yingXiangProduct.getLastTime());
			}
		}
		
		int count = borrowInvestorService.fqueryInvestRecodeCountByMap(para);
		yxpage.setTotalCount(count);
		yxpage.setResult(investrecord);
		}
		return yxpage;
	}
	/**
	 * 调查问卷
	 * @param request
	 * @return
	 */
	@RequestMapping(value="questionnaire.htm")
	public ModelAndView questionnaire(HttpServletRequest request) {
		LocalUserDto lud = super.getLocalUser(request);
		ModelAndView mav = new ModelAndView("/questionnaire/question");
		Questionnaire questionnaire = questionnaireService.getQuestionnaireByUid(lud.getUid());
		if(questionnaire == null) {
			mav.addObject("flag","0");//没有做过问卷
		}else {
			mav.addObject("flag","1");
			mav.addObject("questionnaire",questionnaire);
		}
		return mav;
	}
	
	@RequestMapping(value="/analyseQuestion.htm")
	@ResponseBody
	public String analyseQuestion(HttpServletRequest request,@RequestParam("answers[]") Integer[] answers) {
		LocalUserDto lud = super.getLocalUser(request);
		JSONObject json = new JSONObject();
		if(lud == null) {
			json.put("result", "login");
			return json.toJSONString();
		}
		Integer totalCore = 0;
		Integer riskBearingType = 0;
		Date createTime = new Date();
		
		if(answers != null && answers.length == 16) {
			for (int i = 1; i < answers.length; i++) {
				if(i <= 5) {
					totalCore += answers[i];
				}else {
					totalCore += (2*answers[i]);
				}
			}
			if(totalCore >= 25 && totalCore <= 40) {
				riskBearingType = 1;//保守型
			}
			if(totalCore >=41 && totalCore <= 55) {
				riskBearingType = 2;//稳健型
			}
			if(totalCore >= 56 && totalCore <= 70) {
				riskBearingType = 3;//平衡型
			}
			if(totalCore >= 71 && totalCore <= 85) {
				riskBearingType = 4;//成长型
			}
			if(totalCore >= 86 && totalCore <= 100) {
				riskBearingType = 5;//进取型
			}
			Questionnaire updateDto = new Questionnaire();
			updateDto.setFinancialSituation(answers[0]);
			updateDto.setAgeRange(answers[1]);
			updateDto.setEducation(answers[2]);
			updateDto.setJob(answers[3]);
			updateDto.setDisposableIncome(answers[4]);
			updateDto.setInvestmentProportion(answers[5]);
			updateDto.setInvestmentKnowledge(answers[6]);
			updateDto.setInvestmentExperience(answers[7]);
			updateDto.setInvestmentLife(answers[8]);
			updateDto.setInvestmentCycle(answers[9]);
			updateDto.setInvestmentObjective(answers[10]);
			updateDto.setPrimaryObjective(answers[11]);
			updateDto.setInvestmentAttitude(answers[12]);
			updateDto.setInvestmentDistribution(answers[13]);
			updateDto.setFutureInvestmentAttitude(answers[14]);
			updateDto.setRiskBearingType(riskBearingType);
			updateDto.setUid(lud.getUid());
			updateDto.setTotalCore(totalCore);//总分
			updateDto.setCreateTime(createTime);
			try {
				Questionnaire questionnaire = questionnaireService.getQuestionnaireByUid(lud.getUid());
				if(questionnaire == null) {
					questionnaireService.insert(updateDto);
				}else {
					questionnaireService.updateByUid(updateDto);
				}
				json.put("riskBearingType", riskBearingType);
				json.put("totalCore", totalCore);
				json.put("createTime", DateUtil.simpleFormat(createTime));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return json.toJSONString();
	}

	
	//金额处理
	public BigDecimal moneyProcess(BigDecimal param1,BigDecimal param2,String operator) {
		BigDecimal result = BigDecimal.ZERO;
		if(param1 == null || operator == null) {
			return result;
		}
		if(param2 == null || param2 == BigDecimal.ZERO) {
			return param1;
		}
		switch (operator) {
		case "+":
			result = param1.add(param2);
			break;
		case "-":
			result = param1.subtract(param2);
			break;
		case "*":
			result = param1.multiply(param2);
			break;
		default:
			result = param1.divide(param2);
			break;
		}
		return result;
	}
	
	@RequestMapping(value="/offProduct.htm")
	public ModelAndView offProduct(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/member/moreinvestment");
		LocalUserDto lud = super.getLocalUser(request);
		Page<OffProductTransaction> offpage = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToPage(offpage);
		para.put("investPhone", lud.getUserPhone());
		Integer count = borrowInvestorService.queryOffProductTransactionCount(para);
		if(count > 0) {
			List<OffProductTransaction> investrecord = borrowInvestorService.queryOffProductTransaction(para);
			offpage.setTotalCount(count);
			offpage.setResult(investrecord);
			mav.addObject("offpage",offpage);
			mav.addObject("timeType",1);
		}
		return mav;
	}
	
	@RequestMapping(value="/offProductPage.htm")
	public ModelAndView offProductPage(HttpServletRequest request,@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("/member/offproductpage");
		LocalUserDto lud = super.getLocalUser(request);
		Page<OffProductTransaction> offpage = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToPage(offpage);
		if (map.get("timeType").equals("2")){
			para.put("weekend", map.get("timeType"));
		} else if (map.get("timeType").equals("3")){
			para.put("month", map.get("timeType"));
		} else if (map.get("timeType").equals("4")){
			para.put("otherMonth", map.get("timeType"));
		}
		para.put("investPhone", lud.getUserPhone());
		Integer count = borrowInvestorService.queryOffProductTransactionCount(para);
		List<OffProductTransaction> investrecord = borrowInvestorService.queryOffProductTransaction(para);
		offpage.setTotalCount(count);
		offpage.setResult(investrecord);
		mav.addObject("offpage",offpage);
		mav.addObject("timeType",map.get("timeType"));
		return mav;
	}
	
}
