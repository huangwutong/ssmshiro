package com.angsentech.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.angsentech.ssm.entity.User;
import com.angsentech.ssm.mapper.UserMapper;
import com.angsentech.ssm.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	private UserMapper userMapper;

	@Override
	public User findObjByid(Long id) {
		logger.debug("根据ID查询，id：{}",id);
		return userMapper.findObjByid(id);
	}

	@Override
	public PageInfo<User> queryObjs(Integer pageNo, Integer pageSize) {
		logger.debug("分页查看用户：");
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<User> list = userMapper.queryObjsList();
		// 用PageInfo对结果进行包装
		PageInfo<User> page = new PageInfo<User>(list);
		return page;
	}

	@Override
	public Integer add(User user) {
		logger.debug("添加用户，user:{}",user);
		return userMapper.add(user);
	}

	@Override
	public Integer update(User user) {
		logger.debug("修改用户，user:{}",user);
		return userMapper.update(user);
	}

	@Override
	public Integer delete(Long id) {
		logger.debug("删除用户，id:{}",id);
		return userMapper.delete(id);
	}

	@Override
	public Map<String, Object> saveOrUpdate(User user) {
		logger.debug("修改或增加用户，user:{}",user);
		Map<String , Object> map = new HashMap<String , Object>();
		//如果user 为直接返回
		if(user==null){
			return map;
		}
		//如果id等于0，或者为空，调用用户添加功能
		if(user.getId()==0||user.getId()==null){
			logger.debug("添加用户，user：{}",user);
			//如果返回值小于0，则添加失败
			if(userMapper.add(user)<0){
				logger.debug("添加失败");
				map.put("result", false);
				map.put("msg", "添加用户失败，请稍后再试");
				return map;
			}
			logger.debug("添加成功");
			map.put("result", true);
			return map;
		}
		//如果id不为空，调用修改功能
		logger.debug("修改用户，user：{}",user);
		//如果返回值小于0，则添加失败
		if(userMapper.update(user)<0){
			logger.debug("修改失败");
			map.put("result", false);
			map.put("msg", "修改用户失败，请稍后再试");
			return map;
		}
		logger.debug("修改成功");
		map.put("result", true);
		return map;
	}

	@Override
	public User userLogin(String userName, String passWord) {
		User user=new User();
		user.setUserName(userName);
		user.setPassWord(passWord);
		logger.debug("用户登录，user:{}",user);
		return userMapper.userLogin(user);
	}

	@Override
	public Integer saveOrupdateRole(User user) {
		return null;
	}

}
