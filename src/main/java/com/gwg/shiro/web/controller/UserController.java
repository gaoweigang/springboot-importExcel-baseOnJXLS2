package com.gwg.shiro.web.controller;

import com.alibaba.fastjson.JSON;
import com.gwg.shiro.web.common.Result;
import com.gwg.shiro.web.common.ReturnCode;
import com.gwg.shiro.web.dto.UserDto;
import com.gwg.shiro.web.exception.BusinessException;
import com.gwg.shiro.web.service.UserService;
import com.gwg.shiro.web.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Home redirection to swagger api documentation
 */
@RestController
@Api(value = "user", tags = "用户管理")
@RequestMapping({ "/user" })
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);


	@Autowired
	private UserService userService;


	/**
	 * 根据条件查询用户信息 --这个是否可以省略，分页查询已给
	 * @param
	 * @return
	 */
	@ApiOperation(value = "根据条件查询用户信息")
	@RequestMapping(value = "/queryUserInfoById", method = RequestMethod.POST)
	public Result<?> queryUserInfoById(@RequestBody UserDto dto) {
		logger.info("根据条件查询用户信息...");


		return null;
	}


}
