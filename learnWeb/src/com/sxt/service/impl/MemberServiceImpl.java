package com.sxt.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.enums.UserAwardTypeEnum;
import com.sxt.inter.IMemberInfo;
import com.sxt.inter.IMembers;
import com.sxt.inter.dto.MemberMoneyDto;
import com.sxt.models.LdMemberPidInfo;
import com.sxt.models.MemberInfo;
import com.sxt.models.MemberMoney;
import com.sxt.models.MemberRecommenderDetail;
import com.sxt.models.Members;
import com.sxt.service.Base64Encrypt;
import com.sxt.service.GenerateUid;
import com.sxt.service.LdMemberPidInfoService;
import com.sxt.service.LdMemberRewardService;
import com.sxt.service.LdUserSignInLogService;
import com.sxt.service.MemberInfoService;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MemberRecommenderDetailService;
import com.sxt.service.MemberService;
import com.sxt.service.MessageService;
import com.sxt.util.Money;
import com.sxt.util.SHAUtil;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private IMembers iMembers;
	@Autowired
	private IMemberInfo iMemberInfo;
	@Autowired
	private GenerateUid generateUid;
	@Autowired
	private Base64Encrypt base64Encrypt;
	@Autowired
	private MemberMoneyService memberMoneyService;
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private LdMemberRewardService ldMemberRewardService;
	@Autowired
	private LdUserSignInLogService ldUserSignInLogService; 
	@Autowired
	private MemberRecommenderDetailService memberRecommenderDetailService;
	@Autowired
	private LdMemberPidInfoService ldMemberPidInfoService;
	HttpSession session=null;
	public Members fquerybyphone(String user_phone) {
		return	iMembers.fquerybyphone(user_phone);
	}
	public void finsert(Members member) {
		if(member!=null){
			session.setAttribute("member",member);
		}
		iMembers.finsert(member);
	}
	public Members flogin(Members member) {
		return iMembers.flogin(member);
	}
	public Members fQueryNameByUid(int uid) {
	    return iMembers.fQueryNameByUid(uid);	 
	}
	public String fQueryRnByState(int uid) {
		return iMembers.fQueryRnByState(uid);
	}
	public String fquerycardbystate(int uid) {
		return iMembers.fquerycardbystate(uid);
	}
	public void fupdatecard(int uid) {
		iMembers.fupdatecard(uid);
	}
	@Override
	public Members getMembers(int uid) {
		// TODO Auto-generated method stub
		return iMembers.getMembers(uid);
	}
	@Override
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void update(Members member) {
		// TODO Auto-generated method stub
		iMembers.update(member);
	}
	@Override
	public Members validatePass(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return iMembers.validatePass(map);
	}
	@Override
	public void updatePassword(Members member) {
		// TODO Auto-generated method stub
		iMembers.updatePassword(member);
	}
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void updateIsRealName(int uid) {
		// TODO Auto-generated method stub
		iMembers.updateIsRealName(uid);
	}
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void updateErrorCount(int uid) {
		// TODO Auto-generated method stub
		iMembers.updateErrorCount(uid);
	}
	
	public Members login(String username) {
		return iMembers.login(username);
	}
	@Override
	public Members registor(String user_phone,String user_pass,String recommender,String user_name,HttpServletRequest request,String addIp) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		// 取form参数
				// 判断
				if (null == user_name || "" == user_name)
				{
					user_name ="zb"+user_phone;
				}
				// 密码加密
				user_pass = SHAUtil.encryptSHA1(base64Encrypt.encrypt(user_pass));
				Integer uid = generateUid.generateUid();
				Members member = new Members();
				member.setUserPhone(user_phone);
				member.setUserPass(user_pass);
				member.setUserName(user_name);
				member.setRegTime(new Date());
				member.setUserType(1);
				member.setIsRealName("0");
				member.setIsVip("0");
				member.setStatus("0");
				MemberInfo info = new MemberInfo();
				//推荐人逻辑判断
				if(!"".equals(recommender)){
					Members members=iMembers.fquerybyphone(recommender);
					if(members.getUserType()==5){//销售员
						member.setRecommender("");
						info.setSalesUid(members.getJobNumber());
					}else{//其他类型
						member.setRecommender(recommender);
						info.setSalesUid(members.getInfo()==null?null:members.getInfo().getSalesUid());
					}
					//pid逻辑判断
					LdMemberPidInfo pidInfo=ldMemberPidInfoService.getPidInfo(members.getUid());
					LdMemberPidInfo pidInfoAdd=new LdMemberPidInfo();
					pidInfoAdd.setUid(uid);
					if(pidInfo!=null){
						pidInfoAdd.setPid(pidInfo.getPid()+members.getUid()+"_");
					}else{
						pidInfoAdd.setPid(members.getUid()+"_");
					}
					ldMemberPidInfoService.add(pidInfoAdd);
				}else{
					member.setRecommender(recommender);
					info.setSalesUid(null);
				}
				member.setPayPass("");
				member.setUserEmail("");
				member.setIsAddCard("0");
				member.setUid(uid);
				iMembers.addMembers(member);
				info.setUid(uid);
				info.setCreateTime(new Date());
				info.setUpdateTime(new Date());
				info.setFirstBuy(0);
				memberInfoService.addRegister(info);
				memberMoneyService.add(addMoney(uid));
				
				//注册奖励
				ldMemberRewardService.affordUserAward(UserAwardTypeEnum.REG.getCode(), uid, 
						addIp, request);
				//推荐好友注册奖励
				if(member.getRecommender()!=null&&!"".equals(member.getRecommender())){
					Members imember=iMembers.fquerybyphone(member.getRecommender());
					//邀请人记录
					MemberRecommenderDetail memberRecommenderDetail =new MemberRecommenderDetail();
					memberRecommenderDetail.setUid(imember.getUid());
					memberRecommenderDetail.setInfo("推荐好友注册");
					memberRecommenderDetail.setMobilephone(member.getRecommender());
					memberRecommenderDetail.setMobilephone2(user_phone);
					memberRecommenderDetail.setCreatetime(new Date());
					memberRecommenderDetailService.add(memberRecommenderDetail);
					ldMemberRewardService.affordUserAward(UserAwardTypeEnum.RECOMMENDREG.getCode(), 
							imember.getUid(), addIp, request);
					
//					被推荐注册奖励
					ldMemberRewardService.affordUserAward(UserAwardTypeEnum.PRESENTEEREG.getCode(), 
							uid, addIp, request);
				}

				
				//设置个人信息session
				MemberMoneyDto memberMoney = memberMoneyService.queryMemberMoney(member
						.getUid());
				if (memberMoney != null)
				{
					BigDecimal accountMoney = memberMoney.getAccountMoney();
					BigDecimal moneyFreeze = memberMoney.getMoneyFreeze();
					Money money = new Money(accountMoney, Currency.getInstance("CNY"));
					Money money1 = new Money(moneyFreeze, Currency.getInstance("CNY"));
					Money bd = money.subtract(money1);
					member.setMoneys(bd.getAmount());
					member.setTotalScore(memberMoney.getTotalScore());
				}
				return member;
	}
	public MemberMoney addMoney(Integer uid)
	{
		MemberMoney money = new MemberMoney();
		money.setUid(uid);
		money.setAccountMoney(BigDecimal.ZERO);
		money.setBackMoney(BigDecimal.ZERO);
		money.setBorrowVouchCuse(BigDecimal.ZERO);
		money.setBorrowVouchLimit(BigDecimal.ZERO);
		money.setCanusemoney(BigDecimal.ZERO);
		money.setCreateTime(new Date());
		money.setCreditCuse(BigDecimal.ZERO);
		money.setCreditLimit(BigDecimal.ZERO);
		money.setExperienceGold(BigDecimal.ZERO);
		money.setFreeWithdraw(BigDecimal.ZERO);
		money.setIncomeMoney(BigDecimal.ZERO);
		money.setInvestVouchCuse(BigDecimal.ZERO);
		money.setInvestVouchLimit(BigDecimal.ZERO);
		money.setMoneyCollect(BigDecimal.ZERO);
		money.setMoneyFreeze(BigDecimal.ZERO);
		money.setTotalScore(0);
		money.setUpdateTime(new Date());
		return money;
	}
	@Override
	public List queryJobNumber(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return iMembers.queryJobNumber(maps);
	}
	@Override
	public Integer queryJobNumberCount(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return iMembers.queryJobNumberCount(maps);
	}
	@Override
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void updateUserName(String userName, Integer uid) {
		// TODO Auto-generated method stub
		iMembers.updateUserName(userName, uid);
		iMemberInfo.updateExtfiled(uid);
	}
}
