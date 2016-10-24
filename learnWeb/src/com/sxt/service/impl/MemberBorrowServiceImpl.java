package com.sxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IMemberBorrow;
import com.sxt.models.MemberBorrow;
import com.sxt.service.MemberBorrowService;
@Service
public class MemberBorrowServiceImpl implements MemberBorrowService {
	@Autowired
	private IMemberBorrow iMemberBorrow;
	public List<MemberBorrow> fqueryborrowlist(int uid) {
		return iMemberBorrow.fqueryborrowlist(uid);
	}
	public void insertBorrow(MemberBorrow memberborrow)
	{
		iMemberBorrow.insertBorrow(memberborrow);
	}

}
