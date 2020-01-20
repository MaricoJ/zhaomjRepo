package com.evan.wj.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.evan.wj.dao.UserMapper;
import com.evan.wj.pojo.User;
import com.evan.wj.service.UserService;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
