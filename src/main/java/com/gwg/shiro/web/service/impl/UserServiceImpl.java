package com.gwg.shiro.web.service.impl;

import com.github.pagehelper.PageInfo;
import com.gwg.shiro.web.controller.UserController;
import com.gwg.shiro.web.dao.UserDao;
import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.model.User;
import com.gwg.shiro.web.service.UserService;
import com.gwg.shiro.web.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDao userDao;
	@Autowired
	private AccountDao accountDao;

	@Autowired
	private UserRoleDao userRoleDao;

	public User getUserByUserid(String userid) {
		return userDao.queryUserByUserid(userid);
	}



	public PageInfo<UserVo> queryUserInfoByLimit(UserDto dto) throws BusinessException{
		return userDao.queryUserInfoByLimit(dto);
	}



	/**
	 * 根据id查询用户信息
	 */
	public UserVo queryUserInfoById(UserDto dto) {
		return userDao.queryUserInfoById(dto);
	}
}
