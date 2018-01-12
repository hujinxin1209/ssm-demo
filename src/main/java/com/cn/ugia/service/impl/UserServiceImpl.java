package com.cn.ugia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Override
	public void saveUser(User user) {
		userDao.updateByPrimaryKey(user);
	}
	
	
	@Override
	@Transactional
	public void insertUser(User user) {
//		添加测试代码，测试事务提交
//		user.setAge(111);
//		user.setPassword("111");
//		user.setUserName("111");
//		User user1 = new User();
//		user1.setAge(222);
//		user1.setPassword("2222222222222222222222222222222222");
//		user1.setUserName("222");
		

		userDao.insert(user);
//		userDao.insert(user1);
	}
    
  
}