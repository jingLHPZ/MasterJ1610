package com.sxt.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.enums.MessageTypeEnum;
import com.sxt.inter.ILdParameter;
import com.sxt.inter.ILdRewardCode;
import com.sxt.inter.ILdRewardType;
import com.sxt.inter.IMemberInfo;
import com.sxt.inter.IMembers;
import com.sxt.models.LdRewardCode;
import com.sxt.models.LdRewardType;
import com.sxt.models.MemberInfo;
import com.sxt.models.Members;
import com.sxt.service.LdRewardCodeService;
import com.sxt.service.MessageService;
import com.sxt.util.StringUtil;

/**
 * 奖励码service
 * @author 
 * @date：2016年3月2日 下午5:50:24
 * 
 */
@Service
public class LdRewardCodeServiceImpl implements LdRewardCodeService {

	private static Log logger = LogFactory.getLog(LdRewardCodeServiceImpl.class);
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private ILdRewardCode iLdRewardCode;
	@Autowired
	private IMembers iMembers;
	@Autowired
	private ILdRewardType iLdRewardType;
	@Autowired
	private ILdParameter iLdParameter;
	@Autowired
	private IMemberInfo iMemberInfo;
	
	@Override
	public void sendCode(int uid) {
		
	}

}
