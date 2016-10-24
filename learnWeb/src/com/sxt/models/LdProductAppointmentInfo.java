package com.sxt.models;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author jl
 * 高端理财预约记录表
 */
public class LdProductAppointmentInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productId;
	private Integer appointmentUid;//预约用户uid
	private String saleUid;//所属销售uid
	private Integer appointmentAmount;//预约金额（万元）
	private Date applyTime;//申请时间
	private Integer type;//产品类型 1为私募基金 2 券商理财
	
	public LdProductAppointmentInfo() {
		super();
	}
	
	
	public LdProductAppointmentInfo(String productId, Integer appointmentUid,
			String saleUid, Integer appointmentAmount, Date applyTime,
			Integer type) {
		super();
		this.productId = productId;
		this.appointmentUid = appointmentUid;
		this.saleUid = saleUid;
		this.appointmentAmount = appointmentAmount;
		this.applyTime = applyTime;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getAppointmentUid() {
		return appointmentUid;
	}
	public void setAppointmentUid(Integer appointmentUid) {
		this.appointmentUid = appointmentUid;
	}
	public String getSaleUid() {
		return saleUid;
	}
	public void setSaleUid(String saleUid) {
		this.saleUid = saleUid;
	}
	public Integer getAppointmentAmount() {
		return appointmentAmount;
	}
	public void setAppointmentAmount(Integer appointmentAmount) {
		this.appointmentAmount = appointmentAmount;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
