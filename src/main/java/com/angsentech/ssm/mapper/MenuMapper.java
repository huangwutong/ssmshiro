package com.angsentech.ssm.mapper;

import java.util.List;

import com.angsentech.ssm.dao.AbstractDao;
import com.angsentech.ssm.entity.Menu;

public interface MenuMapper extends AbstractDao<Menu>{
	
	List<Menu> selectAllMenu();

}
