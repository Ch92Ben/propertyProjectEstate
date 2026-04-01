<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/pure-min.css">
<link rel="stylesheet" href="css/custom.css">
<title>Inactive account</title>
</head>
<body>
	<%@ include file="inactiveUserMenu.jsp"%>
	<div align="center">
		<br> <img alt="inactive_account" width="250" height="250"
			src="images/inactive_account.jpg"> <br>
		<p>Hello ${user.userName}, please wait for an administrator to
			activate your account.</p>
		<p>If the problem persist, please contact the administration at:
			info@realEstateProject.com.</p>
		<p>Thank you for your patience and on behalf of Real Estate
			Project we apologise for any inconvenience.</p>

	</div>
</body>
</html>