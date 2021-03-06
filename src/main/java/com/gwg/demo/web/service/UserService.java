package com.gwg.demo.web.service;

import com.github.pagehelper.PageInfo;
import com.gwg.demo.web.dto.UserDto;
import com.gwg.demo.web.exception.BusinessException;
import com.gwg.demo.web.model.User;
import com.gwg.demo.web.vo.UserVo;

/**
 * Created by
 */
public interface UserService{


    /**
     * 根据userid得到用户信息
     * @return
     */
    public User getUserByUserid(String userid);



    /**
     * 分页查询-根据条件查询用户信息
     */
    public PageInfo<UserVo> queryUserInfoByLimit(UserDto dto) throws BusinessException;


        /**
         * 根据userid查询用户信息
         */
    public UserVo queryUserInfoById(UserDto dto) throws BusinessException;




}
