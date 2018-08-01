package com.angsentech.ssm.service;

import com.angsentech.ssm.entity.Role;

public interface RoleService extends AbstractService<Role> {
	
	Integer updateRolePermission(Role role);

}
