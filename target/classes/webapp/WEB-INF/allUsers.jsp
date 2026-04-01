<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/pure-min.css">
<link rel="stylesheet" href="css/custom.css">
<title>All Users</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<h2>All Users</h2>

	<table class="pure-table pure-table-bordered pure-table-striped">
		<thead>
			<tr>
				<th align="left">User ID</th>
				<th align="left">First name</th>
				<th align="left">Last name</th>
				<th align="left">User name</th>
				<th align="left">E-mail</th>
				<th align="left">Password</th>
				<th align="left">Phone number</th>
				<th align="left">Account type</th>
				<th align="left">Account status</th>
				<th colspan="2" style="background-color: red" align="left">Account
					settings</th>
			</tr>
		<thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.userName}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
					<td>${user.phoneNumber}</td>
					<td>${user.accountType.getName()}</td>
					<td>${user.accountStatus.getName()}</td>
					<td><a href="DeleteUser?id=${user.userId}">Remove account</a></td>
					<td><a href="EditUser?id=${user.userId}">Edit user details</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>
