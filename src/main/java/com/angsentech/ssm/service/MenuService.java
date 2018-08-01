package com.angsentech.ssm.service;

import java.util.List;

import com.angsentech.ssm.entity.Menu;

public interface MenuService extends AbstractService<Menu>{

	List<Menu> selectAllMenu();
}
