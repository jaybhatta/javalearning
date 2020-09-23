package com.jay.usermgmtsystem.dao;

import java.util.List;

import com.jay.usermgmtsystem.model.User;

public interface UserDao {
	
 void saveUser(User user);

 void updateUser(User user);

 User getUserById(int id);

 void deleteUserById(int id);

List<User> getAllUserInfo();



}
