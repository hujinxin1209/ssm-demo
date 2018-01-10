package com.cn.ugia.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.ugia.IDao.UserMapper;
import com.cn.ugia.domain.User;
import com.cn.ugia.service.IUserService;

@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private UserMapper userDao;  
    @Override  
    public User getUserById(int userId) {  
        return this.userDao.selectByPrimaryKey(userId);  
    }  
  
}