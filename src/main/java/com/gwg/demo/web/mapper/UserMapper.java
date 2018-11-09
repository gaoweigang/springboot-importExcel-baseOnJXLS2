package com.gwg.demo.web.mapper;

import com.gwg.demo.web.dto.UserDto;
import com.gwg.demo.web.exception.BusinessException;
import com.gwg.demo.web.model.User;
import com.gwg.demo.web.vo.UserVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    /**
     * 根据条件分页查询用户信息
     * @param dto
     * @return
     */
    public List<UserVo> queryUserInfo(UserDto dto) throws BusinessException;


}