<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Form</title>
</head>
<body>
<div><%@ include file="Header.jsp" %></div>
<div>
	<form action="UserController" method="post">
		<div>
			<label>Username</label> <input type="text" name="uname">
		</div>
		
		<div>
			<label>Email</label><input type="text" name="email">
		</div>
		
		<div>
			<label>Password</label><input type="password" name="pass">
		</div>
		
		<div>
			<label>Gender</label>
			<input type="radio" name="gender" value="Male">Male
			<input type="radio" name="gender" value="Female">Female
			
		</div>
		<div>
			<label>Hobbies</label>
			<input type="checkbox" name="hobbies" value="Playing">Playing
			<input type="checkbox" name="hobbies" value="Reading">Reading
			
		</div>
		<div>
			<label>Nationality</label>
			<select name="nationality">
			<option>Nepal</option>
			<option>India</option>
			<option>China</option>
			<option>America</option>
			<option>Japan</option>
			</select>
		</div>
		<div>
			<label>DOB</label><input type="date" name="dob">
		</div>
		<div>
		<input type="submit" value="submit"></button>
		</div>
		



	</form>


</div>

</body>
</html>