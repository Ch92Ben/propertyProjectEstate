<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/pure-min.css">
<link rel="stylesheet" href="css/custom.css">
<title>User Profile</title>
</head>
<body>
	<%@ include file="estateAgentMenu.jsp"%>
	<h2>User Profile for ${user.userName}</h2>

	<table class="pure-table pure-table-bordered pure-table-striped">
		<thead>
			<tr>
				<th align="left">Id</th>
				<th align="left">User name</th>
			</tr>
		<thead>
		<tbody>
			<tr>
				<td>${user.userId}</td>
				<td>${user.userName}</td>
			</tr>
		</tbody>
	</table>

</body>
</html>
