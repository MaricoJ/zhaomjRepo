package com.evan.wj.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.evan.wj.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}


