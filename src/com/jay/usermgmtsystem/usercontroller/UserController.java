package com.jay.usermgmtsystem.usercontroller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jay.usermgmtsystem.model.User;
import com.jay.usermgmtsystem.service.UserService;
import com.jay.usermgmtsystem.service.UserServiceImpl;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  String USER_FORM="UserForm.jsp";
	private static  String USER_EDIT_FORM="EditUser.jsp";
	private static  String USER_LIST="UserList.jsp";
	
	
	 UserService userService = new UserServiceImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String a = request.getParameter("actions");
		
		String Forward ="";
				
		if(a.equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("user", userService.getUserById(id));
			Forward = USER_EDIT_FORM;
			
		}else if (a.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			userService.deleteUserById(id);
			request.setAttribute("users", userService.getAllUserInfo());
			Forward = USER_LIST;
		}else if(a.equals("add")){
			Forward = USER_FORM;
		}else if (a.equals("list")) {
			request.setAttribute("users", userService.getAllUserInfo());
			Forward = USER_LIST;
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(Forward);
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		User user = new User();
		
		
	 user.setUsername(request.getParameter("uname"));
	 user.setEmail(request.getParameter("email"));
	 user.setPassword(request.getParameter("pass"));
	 user.setGender(request.getParameter("gender"));
	 
	 String hobbies ="";
	 String [] hobbi = request.getParameterValues("hobbies");
	 for (String h : hobbi) {
		 hobbies = hobbies+ h + ","; 
	}
	 user.setHobbies(hobbies);
	 
	 user.setNationality(request.getParameter("nationality"));
	
	try {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		 
		 Date date = sdf.parse(request.getParameter("dob"));
		 user.setDob(date);
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	
	String userId = request.getParameter("id");
	if(userId == null || userId.isEmpty()) {
		userService.saveUser(user);
	}else {
		int id = Integer.parseInt(userId);
		user.setId(id);
		userService.updateUser(user);
	}
	
	
	RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
	request.setAttribute("users", userService.getAllUserInfo());
	rd.forward(request, response);
	}

}
