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
<title>Register</title>
</head>
<body>
	<h1>Register for the real estate</h1>
	<sf:form action="RegisterSubmit" modelAttribute="user" method="post"
		class="pure-form pure-form-stacked">
		<div>
			<div>${message}</div>
			<label for="firstName">First Name:</label> <input type="text"
				name="firstName" required="required">
		</div>
		<div>
			<label for="lastName">Last Name:</label> <input type="text"
				name="lastName" required="required">
		</div>
		<div>

			<label for="userName">User Name:</label> <input type="text"
				name="userName" required="required">
		</div>
		<div>
			<label for="password">Password:</label> <input type="password"
				name="password" required="required">
		</div>

		<div>
			<label for="email">Email:</label> <input type="text" name="email"
				required="required">
		</div>
		<div>
			<sf:label path="phoneNumber">Phone number:</sf:label>
			<input type="text" name="phoneNumber" required="required">
		</div>


		<div>
			<sf:label path="accountType">Account type:</sf:label>
			<sf:select path="accountType" items="${accountTypes}"
				itemLabel="name" required="required" />
		</div>

		<div>
			<sf:label path="accountStatus"></sf:label>

		</div>
		<button class="pure-button pure-button-primary" type="submit">Register</button>
	</sf:form>
</body>
</html>