package com.gwg.demo.web.service.impl;

import com.github.pagehelper.PageInfo;
import com.gwg.demo.web.dao.UserDao;
import com.gwg.demo.web.dto.UserDto;
import com.gwg.demo.web.exception.BusinessException;
import com.gwg.demo.web.model.User;
import com.gwg.demo.web.service.UserService;
import com.gwg.demo.web.vo.UserVo;
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

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;


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
