<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserList</title>
</head>
<body>
<div><%@ include file="Header.jsp" %></div>
	<h1>This is UserLIst</h1>
	<div><a href="UserController?actions=add">Add</a></div>
	<div>
		<c:if test="${!empty users}">
			<table>
				<thead>
					<tr>
						<th>SN</th>
						<th>Id</th>
						<th>Username</th>
						<th>Email</th>
						<th>Password</th>
						<th>Gender</th>
						<th>Hobbies</th>
						<th>Nationality</th>
						<th>DOB</th>
						<th>Actions</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${users}" var="u" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td>${u.id}</td>
							<td>${u.username}</td>
							<td>${u.email}</td>
							<td>${u.password}</td>
							<td>${u.gender}</td>
							<td>${u.hobbies}</td>
							<td>${u.nationality}</td>
							<td>${u.dob}</td>
							<td><a href="UserController?actions=edit&id=${u.id}">Edit</a>|<a href="UserController?actions=delete&id=${u.id}">Delete</a></td>
						</tr>




					</c:forEach>


				</tbody>

			</table>
		</c:if>

	</div>
</body>
</html>