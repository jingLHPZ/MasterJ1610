package com.sxt.models;

public class LdParameter implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	//参数名
    private String name;

    //参数显示名称
    private String title;

    //参数值
    private String value;
    
    //参数是否有效   0:无效      1:有效
    private String status;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LdParameter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LdParameter(String name, String title, String value,
			String status) {
		super();
		this.name = name;
		this.title = title;
		this.value = value;
		this.status = status;
	}
	
	
}
