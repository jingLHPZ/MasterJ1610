package com.sxt.inter.dto;

import java.io.Serializable;
import java.util.Date;

public class ImageDto implements Serializable{
	
	private static final long serialVersionUID = 7760854434803988338L;
	
	private Integer id;
	
	private Integer type;
	
	private String url;
	
	private Integer imageIndex;
	
	private Date expireTime;
	
	private Date inOperationTime;
	
	private String imageName;
	
	private Integer status;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getImageIndex() {
		return imageIndex;
	}

	public void setImageIndex(Integer imageIndex) {
		this.imageIndex = imageIndex;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Date getInOperationTime() {
		return inOperationTime;
	}

	public void setInOperationTime(Date inOperationTime) {
		this.inOperationTime = inOperationTime;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
