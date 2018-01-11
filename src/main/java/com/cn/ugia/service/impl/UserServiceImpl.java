package com.cn.ugia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.ugia.IDao.UserMapper;
import com.cn.ugia.domain.User;
import com.cn.ugia.service.IUserService;
import com.cn.ugia.util.Page;

@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private UserMapper userDao;  
    @Override  
    public User getUserById(int userId) {  
        return this.userDao.selectByPrimaryKey(userId);  
    }
	@Override
	public int addUser(User user) {
		return this.userDao.insert(user);
	}
	@Override
	public List<User> listUser() {
		return userDao.listUser();
	}
//	@Override
//	public int total() {
//		return userDao.total();
//	}
//	@Override
//	public List<User> listUser(Page page) {
//		return userDao.listUser(page);
//	}  
    
  
}