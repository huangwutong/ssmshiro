package com.angsentech.ssm.entity;

import java.util.HashSet;
import java.util.Set;

import com.angsentech.ssm.dao.SqlDomain;

public class Role implements SqlDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1682639162740897938L;
	
	private Long id;
	private String roleName;
	private String remark;
	private Set<Permission> permeissionSet = new HashSet<Permission>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<Permission> getPermeissionSet() {
		return permeissionSet;
	}
	public void setPermeissionSet(Set<Permission> permeissionSet) {
		this.permeissionSet = permeissionSet;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", remark=" + remark + ", permeissionSet=" + permeissionSet
				+ "]";
	}
	
	

}
