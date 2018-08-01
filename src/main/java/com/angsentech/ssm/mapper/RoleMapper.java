package com.angsentech.ssm.mapper;

import com.angsentech.ssm.dao.AbstractDao;
import com.angsentech.ssm.entity.Role;

public interface RoleMapper extends AbstractDao<Role> {

	Integer deleteRolePermission (Long id);
	
	Integer addRolePermission(Role role);
}
