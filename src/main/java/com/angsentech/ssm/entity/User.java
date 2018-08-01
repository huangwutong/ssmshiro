package com.angsentech.ssm.entity;

import java.util.HashSet;
import java.util.Set;

import com.angsentech.ssm.dao.SqlDomain;

/**
 * 用户实体类
 * @author 孙钊宁
 * @date 2016年7月26日
 * @version 1.0
 */
public class User implements SqlDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6281737887646562137L;
	
	private Long id;
	private String userName;
	private String passWord;
	private String realName;
	private Set<Role> roleSet = new HashSet<Role>();
	private Set<Permission> permissionSet = new HashSet<Permission>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	public Set<Permission> getPermissionSet() {
		return permissionSet;
	}
	public void setPermissionSet(Set<Permission> permissionSet) {
		this.permissionSet = permissionSet;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", realName=" + realName
				+ ", roleSet=" + roleSet + ", permissionSet=" + permissionSet + "]";
	}

	
}
