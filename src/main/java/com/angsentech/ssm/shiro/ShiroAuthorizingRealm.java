package com.angsentech.ssm.shiro;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.angsentech.ssm.entity.User;
import com.angsentech.ssm.service.UserService;

/**
 * 用户权限认证
 * @author 孙钊宁
 *
 */
public class ShiroAuthorizingRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(ShiroAuthorizingRealm.class);

    @Resource
    private UserService userService;
    
    /**
     * Shiro登录认证 
     * 原理：用户提交 用户名和密码  --- 
     * shiro 封装令牌 ---- 
     * realm 通过用户名将密码查询返回 ---- 
     * shiro 自动去比较查询出密码和用户输入密码是否一致---- 
     * 进行登陆控制 
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
    	logger.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user=userService.userLogin(token.getUsername(),String.valueOf(token.getPassword()));
        logger.debug("用户信息,user:{}",user);
        if(user!=null){
        	SecurityUtils.getSubject().getSession().setAttribute("shiroUser",user);
        	return new SimpleAuthenticationInfo(user.getRealName(), user.getPassWord(),user.getUserName());
        }else{
        	throw new UnknownAccountException();
        }
    }

    /**
     * Shiro权限认证
     */
	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
}
