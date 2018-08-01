package com.angsentech.ssm.mapper;

import com.angsentech.ssm.dao.AbstractDao;
import com.angsentech.ssm.entity.User;

/**
 * 用户mapper
 * @author 孙钊宁
 * @date 2016年7月26日
 * @version 1.0
 */
public interface UserMapper extends AbstractDao<User> {
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	User userLogin(User user);
}
