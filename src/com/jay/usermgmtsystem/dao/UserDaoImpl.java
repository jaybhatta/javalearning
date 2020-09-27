package com.jay.usermgmtsystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jay.usermgmtsystem.model.User;
import com.jay.usermgmtsystem.util.DbConnection;

public class UserDaoImpl implements UserDao{
	private final static String INSERT_SQL = "insert into user_tab (name, email, password, gender, hobbies, nationality, dob) value (?,?,?,?,?,?,?)";
	private final static String UPDATE_SQL = "update user_tab set name=?, email=?, password=?,gender=?, hobbies=?, nationality=?, dob=? where id=?";
	private final static String SELECT_BY_ID_SQL = "select * from user_tab where id=?";
	private final static String DELETE_SQL = "delete from user_tab where id=?";
	private final static String SELECT_ALL_SQL = "select * from user_tab";


	@Override
	public void saveUser(User user) {
		 
		try(Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);) 
		{
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getGender());
				ps.setString(5, user.getHobbies());
				ps.setString(6, user.getNationality());
				ps.setDate(7, new Date(user.getDob().getTime()));
			
				
			ps.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void updateUser(User user) {
		try(Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE_SQL);) 
			{
					ps.setString(1, user.getUsername());
					ps.setString(2, user.getEmail());
					ps.setString(3, user.getPassword());
					ps.setString(4, user.getGender());
					ps.setString(5, user.getHobbies());
					ps.setString(6, user.getNationality());
					ps.setDate(7,new Date(user.getDob().getTime()) );
					ps.setInt(8, user.getId());
				ps.executeUpdate();
			
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
		
	}

	@Override
	public User getUserById(int id) {
		User user = new User();
		try(Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_BY_ID_SQL);)
		
			{
				ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setGender(rs.getString("gender"));
			user.setHobbies(rs.getString("hobbies"));
			user.setNationality(rs.getString("nationality"));
			user.setDob(rs.getDate("dob"));
			}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		return user;
	}

	@Override
	public void deleteUserById(int id) {
		
		try(Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE_SQL);) 
			{
			ps.setInt(1, id);
			ps.executeUpdate();
			
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
	
		
	}

	@Override
	public List<User> getAllUserInfo() {
      List<User> userList = new ArrayList<User>();
      
      try(Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_ALL_SQL);) 
			{
    	  ResultSet rs = ps.executeQuery();
    	  while(rs.next()) {
    		  User user = new User();
    		  user.setId(rs.getInt("id"));
    		  user.setUsername(rs.getString("name"));
    		  user.setEmail(rs.getString("email"));
    		  user.setPassword(rs.getString("password"));
    		  user.setGender(rs.getString("gender"));
    		  user.setHobbies(rs.getString("hobbies"));
    		  user.setNationality(rs.getString("nationality"));
    		  user.setDob(rs.getDate("dob"));
    		  userList.add(user);
    	  }
    	  
    	 
    	  
             } catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
		return userList;
	}

	
}
