<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/pure-min.css">
<link rel="stylesheet" href="css/custom.css">
<title>Edit User</title>
</head>
<body>
	<h1>Editing User</h1>

	<sf:form method="post" action="EditUserSubmit" modelAttribute="user"
		class="pure-form pure-form-stacked">

		<div>
			<sf:label path="firstName">First Name:</sf:label>
			<sf:input path="firstName" required="required" size="30"
				maxlength="50" />
		</div>
		<div>
			<sf:label path="lastName">Last Name:</sf:label>
			<sf:input path="lastName" required="required" size="30"
				maxlength="50" />
		</div>

		<div>
			<sf:label path="password">Password:</sf:label>
			<sf:input path="password" required="required" size="30"
				maxlength="50" />
		</div>
		<div>
			<sf:label path="userName">User name:</sf:label>
			<sf:input path="userName" required="required" size="30"
				maxlength="50" />
		</div>

		<div>
			<sf:label path="accountStatus">Account status:</sf:label>
			<sf:select path="accountStatus" items="${accountStatuses}"
				itemLabel="name" required="required" />
		</div>
		<div>
			<sf:label path="accountType">Account type:</sf:label>
			<sf:select path="accountType" items="${accountTypes}"
				itemLabel="name" required="required" />
		</div>

		<div>
			<sf:label path="phoneNumber">Phone number:</sf:label>
			<sf:input path="phoneNumber" required="required" size="30"
				maxlength="50" />
		</div>
		<div>
			<sf:label path="email">E-mail:</sf:label>
			<sf:input path="email" required="required" size="30" maxlength="50" />
		</div>

		<sf:hidden path="userId" />
		<p>
			<input type="submit" value="Update"
				class="pure-button pure-button-primary" />
			<input type="submit"
				value="Cancel" onclick="history.go(-1); return false;"
				class="pure-button pure-button-primary" />
		</p>

	</sf:form>

</body>
</html>