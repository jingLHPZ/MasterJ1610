package com.sxt.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sxt.base.utils.PatternHelper;
import com.sxt.inter.dto.FormConvertToVo;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.MemberInfo;
import com.sxt.models.MemberRecommenderDetail;
import com.sxt.models.Members;
import com.sxt.page.util.Page;
import com.sxt.page.util.PageUtils;
import com.sxt.service.MemberInfoService;
import com.sxt.service.MemberRecommenderDetailService;
import com.sxt.service.MemberService;
import com.sxt.util.MatrixToImageWriter;
import com.sxt.util.PropertiesRead;

@Controller
@RequestMapping("invite")//邀请
public class MemberRecommenderDetailController extends AbstractGeneralController
{
	@Autowired
	private MemberRecommenderDetailService memberRecommenderDetailService;
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private MemberService iMembers;
	
	public Page<MemberRecommenderDetail> fqueryrecordlist(HttpServletRequest request){
		LocalUserDto lud=super.getLocalUser(request);
		Page<MemberRecommenderDetail> proPage = PageUtils.getPage(request);
		Map<String, Object> param = FormConvertToVo.covertToPage(proPage);
		if(lud.getUid()!=0){
			if(lud.getUserType()==5){//销售员
				Members members=iMembers.fquerybyphone(lud.getUserPhone());
				//工号
				Integer jobNumber=members.getJobNumber();
				param.put("salesUid", jobNumber);
				//查询该工号下面所有的人员
				List<Members> memberList=iMembers.queryJobNumber(param);
				if(memberList.size()>0){
					List<MemberRecommenderDetail> detailList=new ArrayList<MemberRecommenderDetail>();
					for (Members member : memberList) {
						MemberRecommenderDetail detail=new MemberRecommenderDetail();
						detail.setMembers(new Members());
						String userName=member.getUserName();
						detail.getMembers().setUserName(userName.substring(0, 1)+"****"+userName.substring(userName.length()-1));
						detail.getMembers().setIsRealName(member.getIsRealName());
						detail.getMembers().setRegTime(member.getRegTime());
						detail.setInvestorNum(member.getInvestorNums());
						detailList.add(detail);
					}
					int count=iMembers.queryJobNumberCount(param);
					proPage.setTotalCount(count);
					proPage.setResult(detailList);
				}
			}else{
				param.put("uid",lud.getUid());
				List<MemberRecommenderDetail> inviterecord=memberRecommenderDetailService.fQueryRecordByUid(param);
				if(inviterecord.size()>0){//不为空
					for (MemberRecommenderDetail memberRecommenderDetail : inviterecord)
					{
						String userName=memberRecommenderDetail.getMembers().getUserName();
						memberRecommenderDetail.getMembers().setUserName(userName.substring(0, 1)+"****"+userName.substring(userName.length()-1));
					}
				}
				int count=memberRecommenderDetailService.fCountRecord(lud.getUid());
				proPage.setTotalCount(count);
				proPage.setResult(inviterecord);
			}
			
		}
		return proPage;
	}
	@RequestMapping("fqueryrecordbyuid.htm")
	public ModelAndView fqueryrecordone(HttpServletRequest request){
		ModelAndView mav=new ModelAndView("/member/inviteList");
		Page<MemberRecommenderDetail> proPage=fqueryrecordlist(request);
		//查看该用户有无生产二维码
		MemberInfo info=memberInfoService.fQueryMemberInfoByUid(super.getLocalUser(request).getUid());
		if(info!=null){
			 File f = new File(PropertiesRead.use_classLoador().getProperty("QRcode.url")+"/"+info.getUid()+".jpg");
			 if(!f.exists()){
				 MatrixToImageWriter.setQRCode(info.getUid(),super.getLocalUser(request).getUserPhone());
				 info.setTwoDimensionCodeUrl(info.getUid()+".jpg");
				 memberInfoService.updateTwoDimensionCodeUrl(info);
			 }
		}
		mav.addObject("QRcodeIp", PropertiesRead.use_classLoador().getProperty("QRcode.ip")+super.getLocalUser(request).getUid()+".jpg");
		mav.addObject("QRcodeTargetUrl", PropertiesRead.use_classLoador().getProperty("QRcode.target_url")+"?phone="+super.getLocalUser(request).getUserPhone());
		mav.addObject("fxtpUrl",PropertiesRead.use_classLoador().getProperty("fxtp.url"));
		mav.addObject("proPage",proPage);
		return mav;
	}
	@RequestMapping("fqueryrecordtwobyuid.htm")
	public ModelAndView fqueryrecordtwo(HttpServletRequest request){
		System.out.println(request.getParameter("pageNo")+"--"+request.getParameter("totalCount")+"--"+request.getParameter("pageSize"));
		ModelAndView mav=new ModelAndView("/member/inviteDivList");
		Page<MemberRecommenderDetail> proPage=fqueryrecordlist(request);
		mav.addObject("proPage",proPage);
		return mav;
	}
}
