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
<title>Edit Property</title>
</head>
<body>
	<h1>Editing Property</h1>
	<span class="form-error">${errorMessage}</span>
	<sf:form method="post" action="EditPropertySubmit"
		modelAttribute="property" class="pure-form pure-form-stacked">

		<div>
			<sf:label path="propertyDescription">Property description:</sf:label>
			<sf:input path="propertyDescription" type="text" required="required"
				size="40" maxlength="100" />
		</div>
		<div>
			<sf:label path="propertyType">Property type:</sf:label>
			<sf:select path="propertyType" items="${propertyTypes}"
				itemLabel="name" required="required" />
		</div>
		<div>
			<sf:label path="propertySize">Property size:</sf:label>
			<sf:input path="propertySize" type="text" required="required"
				size="40" maxlength="100" />
		</div>
		<div>
			<sf:label path="propertyAddress">Property address:</sf:label>
			<sf:input path="propertyAddress" type="text" required="required"
				size="40" maxlength="100" />
		</div>

		<div>
			<sf:label path="numberOfRooms">Number of rooms:</sf:label>
			<sf:input path="numberOfRooms" type="text" required="required"
				size="40" maxlength="100" />
		</div>
		<sf:hidden path="propertyId" />
		<p>
			<input type="submit" value="Update"
				class="pure-button pure-button-primary" /> 
			<input type="submit" value="Cancel" onclick="history.go(-1); return false;"
				class="pure-button pure-button-primary" />
		</p>

	</sf:form>
</body>
</html>