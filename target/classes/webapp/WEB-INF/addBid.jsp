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
<title>Add Bid</title>
</head>
<body>
	<%@ include file="buyerMenu.jsp"%>
	<h2>Add a new bid</h2>

	<span class="form-error">${errorMessage}</span>
	<sf:form method="post" action="AddBidSubmit" modelAttribute="bid"
		class="pure-form pure-form-stacked">
		<div>
			<sf:label path="bidAmount">How much would you like you bid on this property?</sf:label>
			<sf:input path="bidAmount" type="text" required="required" size="40"
				maxlength="100" />
		</div>

		<p>
			<input type="submit" value="AddBidSubmit"
				class="pure-button pure-button-primary" /> <input type="submit"
				value="Cancel" name="cancel" class="pure-button pure-button-primary"
				onclick="history.go(-1); return false;" /> <input type="hidden"
				name="id" value="${property.propertyId}" />

		</p>
	</sf:form>
</body>
</html>