package com.jay.usermgmtsystem.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3307/users_info";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
			Class.forName(DRIVER);
			
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}