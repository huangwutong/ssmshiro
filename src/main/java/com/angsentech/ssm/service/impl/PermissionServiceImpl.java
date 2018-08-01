package com.angsentech.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.angsentech.ssm.entity.Permission;
import com.angsentech.ssm.mapper.PermissionMapper;
import com.angsentech.ssm.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	private Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
	
	@Resource
	private PermissionMapper permissionMapper;
	
	@Override
	public Permission findObjByid(Long id) {
		logger.debug("根据id查询权限，id:{}",id);
		return permissionMapper.findObjByid(id);
	}

	@Override
	public PageInfo<Permission> queryObjs(Integer pageNo, Integer pageSize) {
		logger.debug("分页查询权限");
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo,pageSize);
		List<Permission> list = permissionMapper.queryObjsList();
		PageInfo<Permission> page = new PageInfo<Permission>(list);
		return page;
	}

	@Override
	public Integer add(Permission permission) {
		logger.debug("添加权限，permission:{}",permission);
		return permissionMapper.add(permission);
	}

	@Override
	public Integer update(Permission permission) {
		logger.debug("修改权限，permission:{}",permission);
		return permissionMapper.update(permission);
	}

	@Override
	public Integer delete(Long id) {
		logger.debug("删除权限，id：{}",id);
		return permissionMapper.delete(id);
	}

	@Override
	public Map<String, Object> saveOrUpdate(Permission t) {
		// TODO Auto-generated method stub
		return null;
	}

}
