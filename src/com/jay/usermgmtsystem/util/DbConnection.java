package com.jay.usermgmtsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public final static String DRIVER = "com.mysql.jdbc.driver";
	public final static String URL = "jdbc:mysql://localhost:3307/users_info";
	public final static String USER = "root";
	public final static String PASSWORD = "root";
	
	public  static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASSWORD);
		
	}

}
