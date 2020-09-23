package com.jay.usermgmtsystem.service;

import java.util.List;

import com.jay.usermgmtsystem.dao.UserDao;
import com.jay.usermgmtsystem.dao.UserDaoImpl;
import com.jay.usermgmtsystem.model.User;

public class UserServiceImpl implements UserService {
	
	UserDao userdao = new UserDaoImpl();

	@Override
	public void saveUser(User user) {
		userdao.saveUser(user);
		
		
	}

	@Override
	public void updateUser(User user) {
		userdao.updateUser(user);
		
	}

	@Override
	public User getUserById(int id) {
		
		return userdao.getUserById(id);
	}

	@Override
	public void deleteUserById(int id) {
		userdao.deleteUserById(id);
		
	}

	@Override
	public List<User> getAllUserInfo() {
		
		return userdao.getAllUserInfo();
	}

}
