<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/pure-min.css">
<link rel="stylesheet" href="css/custom.css">
<title>All my properties</title>
</head>
<body>
	<%@ include file="sellerMenu.jsp"%>
	<h2>All my properties</h2>
	<span class="form-error">${errorMessage}</span>
	<table class="pure-table pure-table-bordered pure-table-striped">
		<thead>
			<tr>
				<th>Property address</th>
				<th>Current bid amount</th>
				<th colspan="1" style="background-color: red">Property<br>
					actions
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${propertyDetails}" var="property">
				<tr>
					<td>${property.propertyAddress}</td>
					<td>${property.currentBid}</td>
					<td><a href="AcceptOffer?id=${property.propertyId}">Accept
							offer</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
