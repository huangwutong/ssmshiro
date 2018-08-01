package com.angsentech.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.angsentech.ssm.entity.Role;
import com.angsentech.ssm.mapper.RoleMapper;
import com.angsentech.ssm.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public Role findObjByid(Long id) {
		logger.debug("根据id查询角色：id:{}",id);
		return roleMapper.findObjByid(id);
	}

	@Override
	public PageInfo<Role> queryObjs(Integer pageNo, Integer pageSize) {
		logger.debug("分页查看角色");
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Role> list = roleMapper.queryObjsList();
		// 用PageInfo对结果进行包装
		PageInfo<Role> page = new PageInfo<Role>(list);
		return page;
	}

	@Override
	public Integer add(Role role) {
		logger.debug("添加角色,role:{}",role);
		return roleMapper.add(role);
	}

	@Override
	public Integer update(Role role) {
		logger.debug("修改角色，role:{}",role);
		return roleMapper.update(role);
	}

	@Override
	public Integer delete(Long id) {
		logger.debug("删除角色，id：{}",id);
		return roleMapper.delete(id);
	}

	@Override
	public Map<String, Object> saveOrUpdate(Role t) {
		return null;
	}

	@Override
	public Integer updateRolePermission(Role role) {
		logger.debug("更新角色权限,role:{}",role);
		if(role==null){
			return 0;
		}
		if(role.getId()==0 || role.getId()==null){
			return 0;
		}
		roleMapper.deleteRolePermission(role.getId());
		if(roleMapper.addRolePermission(role)<=0){
			return null;
		}
		return 1;
	}

}
