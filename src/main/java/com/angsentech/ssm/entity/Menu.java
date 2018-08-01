package com.angsentech.ssm.entity;

import com.angsentech.ssm.dao.SqlDomain;

public class Menu implements SqlDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8601806273955844083L;
	
	private Long id;
	private String name;
	private String url;
	private String permission;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", url=" + url + ", permission=" + permission + "]";
	}
}
