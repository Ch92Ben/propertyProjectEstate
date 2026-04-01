<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/pure-min.css">
<link rel="stylesheet" href="css/custom.css">
<title>Login</title>
</head>
<body>
	<h1>Log in to the real estate</h1>
	<sf:form action="LoginSubmit" method="post"
		class="pure-form pure-form-stacked">
		<div>
			<div>${message}</div>
			<label for="userName">User Name:</label> <input type="text"
				name="userName" required="required">
		</div>
		<div>
			<label for="password">Password:</label> <input type="password"
				name="password" required="required">
		</div>
		<button type="submit" class="pure-button pure-button-primary">Login</button>

	</sf:form>
</body>
</html>