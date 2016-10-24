package com.sxt.inter;

import java.util.List;

import com.sxt.models.MemberBorrow;

public interface IMemberBorrow {

	public List<MemberBorrow>fqueryborrowlist(int uid);
	
	public void insertBorrow(MemberBorrow memberborrow);
}
