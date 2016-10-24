package com.sxt.service;

import java.util.List;

import com.sxt.models.MemberBorrow;

public interface MemberBorrowService {
	
	public List<MemberBorrow>fqueryborrowlist(int uid);
	
	public void insertBorrow(MemberBorrow memberborrow);
}
