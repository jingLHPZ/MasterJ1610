package com.sxt.models;

import java.io.Serializable;
import java.util.Date;

public class BankInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String bankcode;
	private String bankname;
	private String status;
	private String aliasname;
	private Date updatetime;
	private Date createtime;
	private Integer type;
	private String bankNo;
	private String allInBankNo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
	public String getAliasname() {
		return aliasname;
	}
	public void setAliasname(String aliasname) {
		this.aliasname = aliasname;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public String getAllInBankNo() {
		return allInBankNo;
	}
	public void setAllInBankNo(String allInBankNo) {
		this.allInBankNo = allInBankNo;
	}
	public BankInfo(Integer id, String bankcode, String bankname,
			String status, String aliasname, Date updatetime, Date createtime,
			Integer type) {
		super();
		this.id = id;
		this.bankcode = bankcode;
		this.bankname = bankname;
		this.status = status;
		this.aliasname = aliasname;
		this.updatetime = updatetime;
		this.createtime = createtime;
		this.type = type;
	}
	public BankInfo() {
		super();
	}
}
