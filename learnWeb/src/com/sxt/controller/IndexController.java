package com.sxt.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sxt.base.utils.HttpClientUtil;
import com.sxt.enums.ExperiencetBorrowStatusEnum;
import com.sxt.enums.ImageTypeEnum;
import com.sxt.enums.ProductAdeptedTypeEnum;
import com.sxt.enums.ProductBorrowStatusEnum;
import com.sxt.inter.dto.AssignmentDebtDto;
import com.sxt.inter.dto.FormConvertToVo;
import com.sxt.inter.dto.ImageDto;
import com.sxt.inter.dto.IndexProductDto;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.BorrowInvestor;
import com.sxt.models.CashProduct;
import com.sxt.models.ExperienceProduct;
import com.sxt.models.IncomeRate;
import com.sxt.models.LdYingxiangProduct;
import com.sxt.models.LdYingxiangProductDetail;
import com.sxt.models.NewHandProduct;
import com.sxt.page.util.Page;
import com.sxt.service.BorrowInvestorService;
import com.sxt.service.CashService;
import com.sxt.service.NewsInformationService;
import com.sxt.service.NewsNoticeService;
import com.sxt.service.StaticSourceService;
import com.sxt.service.product.CiProductService;
import com.sxt.service.product.ExperienceProductService;
import com.sxt.service.product.NewHandProductService;
import com.sxt.service.product.SiProductService;
import com.sxt.service.product.YingXiangProductService;
import com.sxt.util.FileUtil;
import com.sxt.util.StringUtil;

@Controller
@RequestMapping("/system")
public class IndexController extends AbstractGeneralController {
	
	@Autowired
	private NewHandProductService newHandProductService;
	
	@Autowired
	private ExperienceProductService experienceProductService;
	
	@Autowired
	private SiProductService  siProductService;
	
	@Autowired
	private BorrowInvestorService borrowInvestorService;
	
	@Autowired
	private CiProductService ciProductService;
	
	@Autowired
	private NewsInformationService newsInformationService;
	
	@Autowired
	private NewsNoticeService nowsNoticeSevice;
	
	@Autowired
	private StaticSourceService staticSourceService;
	
	@Autowired
	private CashService cashService;
	
	@Autowired
	private YingXiangProductService yingXiangProductService;
	
	@RequestMapping(value="/fquerysumway.htm",method=RequestMethod.GET)
	public ModelAndView  fSumWay(HttpServletRequest request){
		ModelAndView model=new ModelAndView("/index");
		LocalUserDto localUser = super.getLocalUser(request);
		initPage(model, localUser);
		model.addObject("active", 1);
		return model;
	}
	
	@RequestMapping("/logout.htm")
	public ModelAndView  logOut(HttpServletRequest request){
		ModelAndView model=new ModelAndView("/index");
		initPage(model, null);
		request.getSession().invalidate();
		return model;
	}
	
	/**
	 * 初始化页面
	 * @param mav
	 */
	private void initPage(ModelAndView model, LocalUserDto localUser){
		model.addObject("newlist", fQueryNewHandProduct());
		model.addObject("exlist", fQueryExperienceProduct());
		model.addObject("silist", fQuerySiPro());
		if(localUser !=null && Integer.parseInt(localUser.getIsRealName()) == 1){
			//含有私募基金的
			model.addObject("silist", queryIndexProduct(localUser.getUid()));
		}
		model.addObject("newsinformationlist", newsInformationService.fqueryinformation());
		model.addObject("newsnoticelist", nowsNoticeSevice.fquerynewsnotice());
		model.addObject("imageList", getImageByType(ImageTypeEnum.BANNER.getCode()));
		model.addObject("path", FileUtil.getBanner());
		model.addObject("cashMap", queryCashProduct());
		model.addObject("queryYingXiangList", queryYingXiangList());
		
		initSh(model);
	}
	/**
	 * 沪深大盘指数
	 */
	private void initSh(ModelAndView model){
		//查询沪深大盘指数
		String s_sh000001 = HttpClientUtil.doGetRequest("http://hq.sinajs.cn/list=s_sh000001", "GBK");
		String s_sz399001 = HttpClientUtil.doGetRequest("http://hq.sinajs.cn/list=s_sz399001", "GBK");
		
		if (StringUtil.isNotEmpty(s_sh000001) && StringUtil.isNotEmpty(s_sz399001)) {
			
			String sh000001[] = s_sh000001.split("=")[1].split(",");
			String sz399001[] = s_sz399001.split("=")[1].split(",");
			
			DecimalFormat df = new DecimalFormat("######0.00");
			String sh000001_total = df.format(Double.valueOf(sh000001[1]));
			String sz399001_total = df.format(Double.valueOf(sz399001[1]));
			String sh000001_amount = df.format(Double.valueOf(sh000001[2]));
			String sz399001_amount = df.format(Double.valueOf(sz399001[2]));
			String sh000001_rate = df.format(Double.valueOf(sh000001[3]));
			String sz399001_rate = df.format(Double.valueOf(sz399001[3]));
			
			model.addObject("sh000001_total", sh000001_total);
			model.addObject("sz399001_total", sz399001_total);
			model.addObject("sh000001_amount", sh000001_amount);
			model.addObject("sz399001_amount", sz399001_amount);
			model.addObject("sh000001_rate", sh000001_rate);
			model.addObject("sz399001_rate", sz399001_rate);
			model.addObject("sh000001_type", Double.valueOf(sh000001[2]) >= 0? "add":"deduct");
			model.addObject("sz399001_type", Double.valueOf(sz399001[2]) >= 0? "add":"deduct");
		}
	}
	
	/**
	 * 私募基金
	 */
	public List<IndexProductDto> queryIndexProduct(Integer uid){
		List<IndexProductDto> products = ciProductService.queryIndexProduct();
		return perfectProduct(products, uid);
	}
	/**
	 * 私募基金状态
	 * @param products
	 *  3、已实名登录、但并未完成问卷时，可显示此类项目，但隐去具体信息（如标题、利率、期限等，均以***代替），且不能进入投资详情页；
	 * 原型注释：“私募基金”项目的显示和购买要求：
	  1、未登录时，【首页】和【我要投资】页不显示“私募基金”项目；
	  2、已登录但未实名时，同上；
	  3、已实名登录、但并未完成问卷时，可显示此类项目，但隐去具体信息（如标题、利率、期限等，均以***代替），且不能进入投资详情页；
	  4、已实名登录、并完成问卷后，可显示项目具体信息，并进入详情页，但不能立即投资；
	  5、已实名登录、并完成问卷后，再等待24小时，才可投资此类项目；
	  6、完成一次问卷，即可查看全部私募基金项目的信息，无需每次都重做。
	 */
	public List<IndexProductDto> perfectProduct(List<IndexProductDto> products, Integer uid){
		
		if(products == null){
			return null;
		}
		for (IndexProductDto product : products){
			if(product.getCollectStartTime().getTime() > new Date().getTime()){
				//即将开始
				product.setBorrowStatus(ProductBorrowStatusEnum.NINE.getCode());
			}
			product.setSurplusmon(BigDecimal.ZERO);
			List<BorrowInvestor> bilist=borrowInvestorService.fQuerySiproByPid(product.getProductId());
			if(bilist.size()>0){
				BigDecimal havaInvestMoney = borrowInvestorService.querySumMoney(product.getProductId());
				BigDecimal surplusmon=product.getBorrowMoney().subtract(borrowInvestorService.querySumMoney(product.getProductId()));//获得该投资项目可投资金融
				product.setSurplusmon(havaInvestMoney);
				product.setCaninvest(BigDecimal.ONE.subtract(surplusmon.divide(product.getBorrowMoney(), 4, RoundingMode.HALF_UP)));

				if(surplusmon.compareTo(BigDecimal.ZERO) > 0 && product.getCollectEndTime().getTime() < new Date().getTime()){
					product.setBorrowStatus(ProductBorrowStatusEnum.FIVE.getCode());
				}
			}else{
				if(product.getCollectEndTime().getTime() < new Date().getTime() && product.getBorrowStatus() == ProductBorrowStatusEnum.THREE.getCode()){
					//流标
					product.setBorrowStatus(ProductBorrowStatusEnum.FIVE.getCode());
				}
			}
			if(product.getProductAdaptedType()==ProductAdeptedTypeEnum.THREE.getCode()){
				//未完成问卷
				Integer count = ciProductService.queryQuestionByUid(uid);
				if(count <= 0){
					product.setBorrowStatus(ProductBorrowStatusEnum.TEN.getCode());
				}
			}
		}
		return products;
	}
	/**
	 * 热卖
	 */
	public IndexProductDto queryIndexHotProduct(){
		IndexProductDto hotProduct = ciProductService.queryHotProduct();
		if(hotProduct!=null){
			if(hotProduct.getCollectStartTime().getTime() > new Date().getTime()){
				//即将开始
				hotProduct.setBorrowStatus(ProductBorrowStatusEnum.NINE.getCode());
			}
			List<BorrowInvestor> bilist=borrowInvestorService.fQuerySiproByPid(hotProduct.getProductId());
			if(bilist.size()>0){
				BigDecimal surplusmon=hotProduct.getBorrowMoney().subtract(borrowInvestorService.querySumMoney(hotProduct.getProductId()));//获得投资项目的总投资金额
				hotProduct.setSurplusmon(surplusmon);
				hotProduct.setCaninvest(BigDecimal.ONE.subtract(surplusmon.divide(hotProduct.getBorrowMoney(), 4, RoundingMode.HALF_UP)));
				if(hotProduct.getSurplusmon().compareTo(BigDecimal.ZERO) > 0 && hotProduct.getCollectEndTime().getTime() < new Date().getTime()){
					hotProduct.setBorrowStatus(ProductBorrowStatusEnum.FIVE.getCode());
				}
			}else{
				if(hotProduct.getCollectEndTime().getTime() < new Date().getTime() && hotProduct.getBorrowStatus() == ProductBorrowStatusEnum.THREE.getCode()){
					//流标
					hotProduct.setBorrowStatus(ProductBorrowStatusEnum.FIVE.getCode());
				}
			}
		}
		return hotProduct;
	}
	/**
	 * 新手标
	 */
	public List<NewHandProduct> fQueryNewHandProduct(){
		List<NewHandProduct> productList = newHandProductService.fQueryProduct();
		if(productList.size() == 0){
			return null;
		}
		for (NewHandProduct product : productList){
			List<BorrowInvestor> bilist=borrowInvestorService.fQuerySiproByPid(product.getProductId());
			if(bilist.size()>0){
				BigDecimal surplusmon=product.getBorrowMoney().subtract(borrowInvestorService.querySumMoney(product.getProductId()));//获得该投资项目可投资金融
				product.setSurplusmon(surplusmon);
				product.setCaninvest(BigDecimal.ONE.subtract(surplusmon.divide(product.getBorrowMoney(), 4, RoundingMode.HALF_UP)));
			}
		}
		return productList;
	}
	/**
	 * 体验标
	 */
	public List<ExperienceProduct> fQueryExperienceProduct(){
		List<ExperienceProduct> productList = experienceProductService.fQueryProduct();
		if(productList.size() == 0){
			return null;
		}
		for (ExperienceProduct product : productList){
			long nowTime = new Date().getTime();
			if(product.getBorrowStatus() == ExperiencetBorrowStatusEnum.PLAN.getCode() && (nowTime > product.getCollectEndTime().getTime()  ||  nowTime < product.getCollectStartTime().getTime()) ){
				product.setBorrowStatus(ExperiencetBorrowStatusEnum.CLOSE.getCode());
			}
			List<BorrowInvestor> bilist=borrowInvestorService.fQuerySiproByPid(product.getProductId());
			if(bilist.size()>0){
				BigDecimal surplusmon = product.getBorrowMoney().subtract(borrowInvestorService.querySumMoney(product.getProductId()));//获得该投资项目可投资金融
				product.setSurplusmon(surplusmon);
				product.setCaninvest(BigDecimal.ONE.subtract(surplusmon.divide(product.getBorrowMoney(), 4, RoundingMode.HALF_UP)));
			}
		}
		return productList;
	}
	/**
	 *散标
	 */
	public List<IndexProductDto>  fQuerySiPro(){
		Map<String,Object> param= new HashMap<String,Object>();
		param.put("tableName", "ld_si_product");
		param.put("tableNameDetail", "ld_si_product_detail");
		param.put("displayFlag", "1");
		List<IndexProductDto> products = ciProductService.fqueryAllProduct(param);
		for (IndexProductDto siProduct : products){
			if(siProduct.getCollectStartTime().getTime() > new Date().getTime()){
				//即将开始
				siProduct.setBorrowStatus(ProductBorrowStatusEnum.NINE.getCode());
			}
			siProduct.setSurplusmon(BigDecimal.ZERO);
			List<BorrowInvestor> bilist=borrowInvestorService.fQuerySiproByPid(siProduct.getProductId());
			if(bilist.size()>0){
				BigDecimal havaInvestMoney = borrowInvestorService.querySumMoney(siProduct.getProductId());
				BigDecimal surplusmon=siProduct.getBorrowMoney().subtract(borrowInvestorService.querySumMoney(siProduct.getProductId()));//获得该投资项目可投资金融
				siProduct.setSurplusmon(havaInvestMoney);
				siProduct.setCaninvest(BigDecimal.ONE.subtract(surplusmon.divide(siProduct.getBorrowMoney(), 4, RoundingMode.HALF_UP)));

				if(surplusmon.compareTo(BigDecimal.ZERO) > 0 && siProduct.getCollectEndTime().getTime() < new Date().getTime()){
					siProduct.setBorrowStatus(ProductBorrowStatusEnum.FIVE.getCode());
				}
			}else{
				if(siProduct.getCollectEndTime().getTime() < new Date().getTime() && siProduct.getBorrowStatus() == ProductBorrowStatusEnum.THREE.getCode()){
					//流标
					siProduct.setBorrowStatus(ProductBorrowStatusEnum.FIVE.getCode());
				}
			}
		}
		return products;
	}
	/**
	 * 涨中宝
	 */
	public List<IndexProductDto>  fQueryCiPro(){
		List<IndexProductDto> products = ciProductService.queryAllCiProduct();
		for(IndexProductDto product: products){
			if(product.getCollectStartTime().getTime() > new Date().getTime()){
				//即将开始
				product.setBorrowStatus(ProductBorrowStatusEnum.NINE.getCode());
			}
			
			product.setHaveInvestMoney(borrowInvestorService.querySumMoney(product.getProductId()));//累计总投资金额
			//累计已投资人数
			product.setHaveInvestorCount(borrowInvestorService.fqueryInvestorCountByProductId(product.getProductId()));
			
			if(product.getBorrowMoney().compareTo(product.getHaveInvestMoney()) > 0 && product.getCollectEndTime().getTime() < new Date().getTime()){
				product.setBorrowStatus(ProductBorrowStatusEnum.FIVE.getCode());
			}
		}
		return products;
	}
	
	/**
	 * 债权转让
	 */
	public List<AssignmentDebtDto> queryAssignDebt() {
		List<AssignmentDebtDto> list = null;
		list = borrowInvestorService.queryAssigningDebt(0, 3);
		return list;
	}
	
	/**
	 * 邀请好友
	 * @return
	 */
	@RequestMapping("friendsInvite")
	public String friendsInvite() {
		return "/friends";
	}
	
	/**
	 * 图片读取
	 */
	public List<ImageDto> getImageByType(Integer type) {
		List<ImageDto> list = staticSourceService.getImageByType(type);
		return list;
	}
	
	/**
	 * 首页活期宝产品信息
	 * @return
	 */
	public Map<String,Object> queryCashProduct() {
		Map<String, Object> cashMap = new HashMap<String, Object>();
		CashProduct cashProduct = cashService.selectCashProduct();
		IncomeRate incomeRate = cashService.queryNewIncomeRate();
		Integer totalUsers = cashService.getTotalUsers();
		BigDecimal totalIncome = cashService.getTotalIncome();
		cashMap.put("cashProduct", cashProduct);
		cashMap.put("incomeRate", incomeRate);
		cashMap.put("totalUsers", totalUsers);
		cashMap.put("totalIncome", totalIncome);
		return cashMap;
	}
	
	/**
	 * 查询盈享理财list
	 * @param request
	 * @return
	 */
	public List<LdYingxiangProduct> queryYingXiangList() {
		
		//	分页查询盈享理财
		Page<LdYingxiangProduct> proPage = new Page<LdYingxiangProduct>();
		proPage.setPageSize2(3);
		Map<String, Object> maps = FormConvertToVo.covertToPage(proPage);
		List<LdYingxiangProduct> productList = yingXiangProductService.queryYingxiangProductList(maps);
		
		for (LdYingxiangProduct product : productList) {
			
			//	查询已投资金额和投资比例
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("productType", 9);
			param.put("productId", product.getProductId());
			param = borrowInvestorService.queryInvestMoneySum(param);
			
			BigDecimal totalInvest = (BigDecimal)param.get("totalCapital");
			BigDecimal borrowMoney = product.getBorrowMoney();
			product.setInvestMoney(totalInvest);
			product.setProcessRate(totalInvest.divide(borrowMoney)
					.multiply(BigDecimal.valueOf(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
			
			//	查询盈享理财明细
			LdYingxiangProductDetail productDetail = yingXiangProductService
					.queryYingxiangProductDetail(product.getProductId());
			product.setMinInvest(productDetail.getInvestMin());
			
			//	即将开始
			if(product.getCollectStartTime().getTime() > new Date().getTime()){
				product.setBorrowStatus(ProductBorrowStatusEnum.NINE.getCode());
			}
			//	流标
			if(ProductBorrowStatusEnum.THREE.getCode() == product.getBorrowStatus() 
					&& product.getCollectEndTime().getTime() < new Date().getTime()){
				product.setBorrowStatus(ProductBorrowStatusEnum.FIVE.getCode());
			}
		}
		
		return productList;
	}
}
