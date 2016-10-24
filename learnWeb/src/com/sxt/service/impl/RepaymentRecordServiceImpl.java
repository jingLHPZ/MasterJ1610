package com.sxt.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IBorrowInvestor;
import com.sxt.inter.ICiProduct;
import com.sxt.inter.IEiProduct;
import com.sxt.inter.IRepaymentDetail;
import com.sxt.inter.IRepaymentRecord;
import com.sxt.inter.ISiProduct;
import com.sxt.inter.IStableProduct;
import com.sxt.inter.ISurplusProduct;
import com.sxt.models.CiProduct;
import com.sxt.models.EiProduct;
import com.sxt.models.InvestorMoney;
import com.sxt.models.SiProduct;
import com.sxt.models.StableProduct;
import com.sxt.models.SumMoney;
import com.sxt.models.SurplusProduct;
import com.sxt.service.RepaymentRecordService;
@Service
public class RepaymentRecordServiceImpl implements RepaymentRecordService {
	@Autowired
	private IRepaymentRecord  iRepaymentRecord;
	@Autowired
	private ICiProduct  iCiProduct;
	@Autowired
	private ISiProduct iSiProduct;
	@Autowired
	private IStableProduct  iStableProduct;
	@Autowired
	private ISurplusProduct iSurplusProduct;
	@Autowired
	private IEiProduct  iEiProduct; 
	@Autowired
	private IBorrowInvestor iBorrowInvestor;
	@Autowired
	private IRepaymentDetail iRepaymentPlan;
	public Date fQueryTimeByuid(Map<String, Object> params) {
		return iRepaymentRecord.fQueryTimeByuid(params);
	}
	
	/**
	 * 债权转让专区
	 */
	public List<SumMoney> fQueryRecord() {
		Map<String,Object> map=new HashMap<String, Object>();
		List<SumMoney> smlist=new ArrayList<SumMoney>();
		smlist=iRepaymentRecord.fQueryRecord();//查询还款人对每个投资者还款了多少钱。
		for (SumMoney sumMoney : smlist) {
			int ivid=sumMoney.getInvestorUid();
			String proid=sumMoney.getProductId();
			BigDecimal rm=sumMoney.getReceiveCapital();
			BigDecimal ri=sumMoney.getReceiveInterest();
			BigDecimal allreceive=rm.add(ri);
			map.put("Investor_uid", ivid);
			map.put("Product_id",proid);
			List<InvestorMoney> imlist=iBorrowInvestor.fInvestorMoney(map);//根据项目iD 和用户ID 查询投资记录投资者对项目投资了多少钱。
			for (InvestorMoney investorMoney: imlist) {
				BigDecimal im=investorMoney.getInvestorCapital();
				BigDecimal ii=investorMoney.getInvestorInterest();
				BigDecimal assignment_money=investorMoney.getAssignmentMoney();//转让金额(转让价)(2)。
				BigDecimal allInvestor=im.add(ii);
				BigDecimal allincome=allInvestor.subtract(allreceive);//到期总收益金额(剩余本息)。（1）
				int day=sumMoney.getDay();
				day=iRepaymentPlan.fRepayPlan(ivid);//还有多少天到期(收到还款日！)。
				
				Date d=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
				String year=sdf.format(d);
				int nf=Integer.parseInt((year.substring(0,4)));
				
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, nf);
				long days=cal.getActualMaximum(Calendar.DAY_OF_YEAR);//今年有多少天（天数）（3）
				//公式
				BigDecimal b=new BigDecimal(days);
				BigDecimal yearrate=sumMoney.getYearrate();
				 yearrate= ((allincome.subtract(assignment_money)).divide(assignment_money).multiply(b));//年华收益率
				//收到还款日
				 String proname=sumMoney.getProname();
				String pid=proid.substring(0,1);
				if(pid=="1"){//安投资
					SiProduct spro=iSiProduct.fQueryProById(pid);
					 proname=spro.getProductName();
				}else if(pid=="2"){//稳投资
					StableProduct sbpro=iStableProduct.fQuerySpProById(pid);
					 proname=sbpro.getProductName();
				}else if(pid=="3"){//盈投资
					SurplusProduct sppro=iSurplusProduct.fQuerySurplusProById(pid);
					 proname=sppro.getProductName();
				}else if(pid=="4"){//畅投资
					CiProduct cpro=iCiProduct.fQueryProById(pid);
					 proname=cpro.getProductName();
				}else if(pid=="5"){//享投资
					EiProduct epro=iEiProduct.fQueryEpProById(pid);
					 proname=epro.getProductName();
				}
			}
		}
		return smlist;
	}
}
