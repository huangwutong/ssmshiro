package com.angsentech.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.angsentech.ssm.entity.Menu;
import com.angsentech.ssm.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	private Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Resource
	private MenuService menuService;
	
	@ResponseBody
	@RequestMapping("/findAll")
	public List<Menu> findAllMenu(){
		List<Menu> list = menuService.selectAllMenu();
		logger.debug("菜单列表：list{}",list);
		return list;
	}
	

}
