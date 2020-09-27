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







//
//<servlet>
//<servlet-name>name</servlet-name>
//<servlet-class>com.jay.usermgmtsystem.controller.UserController</servlet-class>
//</servlet>
//
//<servlet-mapping>
//<servlet-name>name</servlet-name>
//<url-pattern>/UserController</url-pattern>
//</servlet-mapping>

