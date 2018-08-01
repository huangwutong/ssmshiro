package com.angsentech.ssm.service;

import com.angsentech.ssm.entity.User;

public interface UserService extends AbstractService<User>{
	
	/**
	 * 用户登录
	 * @param userName
	 * @param passWord
	 * @return
	 */
	User userLogin(String userName,String passWord);
	
	
	Integer saveOrupdateRole(User user);

}
