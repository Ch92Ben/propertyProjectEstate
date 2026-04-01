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
<title>Adding a property</title>
</head>
<body>
	<h2>Add a new property</h2>

	<span class="form-error">${errorMessage}</span>
	<sf:form method="post" action="AddPropertySubmit"
		modelAttribute="property" class="pure-form pure-form-stacked">
		<div>
			<sf:label path="propertyDescription">Property description:</sf:label>
			<sf:input path="propertyDescription" type="text" required="required"
				size="30" maxlength="100" />
		</div>
		<div>
			<sf:label path="propertyType">Property type:</sf:label>
			<sf:select path="propertyType" items="${propertyTypes}"
				itemLabel="name" required="required" />
		</div>
		<div>
			<sf:label path="propertySize">Property size: (sqm)</sf:label>
			<sf:input path="propertySize" type="text" required="required"
				size="30" maxlength="100" />
		</div>
		<div>
			<sf:label path="propertyAddress">Property address:</sf:label>
			<sf:input path="propertyAddress" type="text" required="required"
				size="30" maxlength="100" />
		</div>
		<div>
			<sf:label path="sellingPrice">Offers over:</sf:label>
			<sf:input path="sellingPrice" type="text" required="required"
				size="30" maxlength="100" />
		</div>
		<div>
			<sf:label path="numberOfRooms">Number of rooms:</sf:label>
			<sf:input path="numberOfRooms" type="text" required="required"
				size="30" maxlength="100" />
		</div>
		<div>
			<sf:label path="seller">Seller name:</sf:label>
			<sf:select path="seller" items="${allSellers}" itemLabel="lastName"
				required="required" />
		</div>
		<p>
			<input type="submit" value="Add property"
				class="pure-button pure-button-primary" /> <input type="submit"
				value="Cancel" name="cancel" class="pure-button pure-button-primary"
				onclick="history.go(-1); return false;" />
		</p>
	</sf:form>
</body>
</html>