package com.angsentech.ssm.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.angsentech.ssm.service.UserService;
import com.angsentech.ssm.util.MD5Utils;

@Controller
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		logger.debug("登录跳转");
		return "/login";
	}
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		logger.debug("进入主页");
		return "/index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String doLogin(String userName,String passWord,ModelMap modelMap){
		logger.debug("登录信息，userName:{},passWord:{}",userName,passWord);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName,MD5Utils.getMD5String(passWord));
		token.setRememberMe(true);
		try{
			subject.login(token);
		}catch(Exception e){
			modelMap.put("msg", "用户或密码错误！");
			logger.debug("用户或密码错误！");
			return "/login";
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "/login";
	}

}
