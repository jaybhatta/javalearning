package com.jay.usermgmtsystem.service;

import java.util.List;

import com.jay.usermgmtsystem.model.User;

public interface UserService {
	void saveUser(User user);

	 void updateUser(User user);

	 User getUserById(int id);

	 void deleteUserById(int id);

	List<User> getAllUserInfo();

}
