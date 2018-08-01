package com.angsentech.ssm.entity;

import com.angsentech.ssm.dao.SqlDomain;

public class Permission implements SqlDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6417905821068931972L;
	
	private Long id;
	private String name;
	private String remark;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
	
	

}
