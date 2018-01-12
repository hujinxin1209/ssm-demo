package com.cn.ugia.service;

import java.util.List;

import com.cn.ugia.domain.User;
import com.cn.ugia.util.Page;

public interface IUserService {
	public User getUserById(int userId);
	
	public int addUser(User user);
	
	public List<User> listUser();
	
	public void saveUser(User user);
	
	public void insertUser(User user);
	
//	int total();
//    public List<User> listUser(Page page);
}
