package com.gwg.demo.web.dao;

import com.github.pagehelper.PageInfo;
import com.gwg.demo.web.dto.UserDto;
import com.gwg.demo.web.exception.BusinessException;
import com.gwg.demo.web.model.User;
import com.gwg.demo.web.vo.UserVo;

public interface UserDao {

    public User queryUserByUserid(String userid);

    /**
     * 分页查询-根据条件查询用户信息
     */
    public PageInfo<UserVo> queryUserInfoByLimit(UserDto dto) throws BusinessException;

    /**
     * 新增-用户
     */
    public boolean addUser(UserDto dto) throws BusinessException;

    /**
     * 根据userid查询用户信息
     */
    public UserVo queryUserInfoById(UserDto dto) throws BusinessException;

    /**
     * 根据userId更新User
     */
    public boolean updateUserByUserId(UserDto dto) throws BusinessException;

}
