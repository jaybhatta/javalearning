<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Edit Form</title>
</head>
<body>
	<div><%@ include file="Header.jsp"%></div>
	<div>
		<form action="UserController" method="post">
			<div>
				<label>Id</label><input type="text" name="id" readonly="readonly" value="${user.id }">
			</div>
			<div>
				<label>Username</label> <input type="text" name="uname" value="${user.username}">
			</div>

			<div>
				<label>Email</label><input type="text" name="email"	value="${user.email}">
			</div>

			<div>
				<label>Password</label><input type="password" name="pass" value = "${user.password}">
			</div>

			<div>
				<label>Gender</label> <input type="radio" name="gender" value="Male"${user.gender eq 'Male' ? 'checked':'' }>Male
				<input type="radio" name="gender" value="Female" ${user.gender eq 'Female'?'checked':'' }>Female

			</div>
			<div>
				<label>Hobbies</label> 
				<input type="checkbox" name="hobbies" value="Playing" <c:if test="${fn:contains(user.hobbies,'Playing') }">checked</c:if>>Playing 
				<input type="checkbox" name="hobbies" value="Reading"<c:if test="${fn:contains(user.hobbies,'Reading')}">checked</c:if>>Reading
																
				 
			</div>
			<div>
				<label>Nationality</label> <select name="nationality" value="${user.nationality }" >
					<option value="Nepal"${user.nationality == 'Nepal'?'selected':'' }>Nepal</option>
					<option value="India"${user.nationality == 'India'?'selcted':'' }>India</option>
					<option value ="China"${user.nationality=='China'?'selected':'' }>China</option>
					<option value ="America"${user.nationality=='America'?'selected':'' }>America</option>
					<option value ="Japan"${user.nationality=='Japan'?'selected':'' }>Japan</option>
				</select>
			</div>
			<div>
				<label>DOB</label><input type="date" name="dob" value="${user.dob}">
			</div>
			<div>
				<input type="submit" value="submit">
				</button>
			</div>




		</form>


	</div>

</body>
</html>