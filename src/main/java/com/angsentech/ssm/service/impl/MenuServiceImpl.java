package com.angsentech.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.angsentech.ssm.entity.Menu;
import com.angsentech.ssm.mapper.MenuMapper;
import com.angsentech.ssm.service.MenuService;
import com.github.pagehelper.PageInfo;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	private Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Resource
	private MenuMapper menuMapper;

	@Override
	public Menu findObjByid(Long id) {
		logger.debug("根据id查询菜单，id:{}",id);
		return menuMapper.findObjByid(id);
	}

	@Override
	public PageInfo<Menu> queryObjs(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer add(Menu menu) {
		logger.debug("添加菜单,menu:{}",menu);
		return menuMapper.add(menu);
	}

	@Override
	public Integer update(Menu menu) {
		logger.debug("修改菜单，menu:{}",menu);
		return menuMapper.update(menu);
	}

	@Override
	public Integer delete(Long id) {
		logger.debug("删除菜单，id：{}",id);
		return menuMapper.delete(id);
	}

	@Override
	public Map<String, Object> saveOrUpdate(Menu t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> selectAllMenu() {
		logger.debug("查询所有菜单");
		return menuMapper.selectAllMenu();
	}

}
