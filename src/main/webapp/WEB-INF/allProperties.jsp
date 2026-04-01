<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/pure-min.css">
<link rel="stylesheet" href="css/custom.css">
<title>All Properties</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<h2>All Properties</h2>
	<table class="pure-table pure-table-bordered pure-table-striped">
		<thead>
			<tr>
				<th>Property description</th>
				<th>Property type</th>
				<th>Property size (sqm)</th>
				<th>Property address</th>
				<th>Offers over</th>
				<th>Number of rooms</th>
				<th>Transaction status</th>
				<th colspan="3" style="background-color: red">Property<br>
					actions
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${properties}" var="property">
				<tr>
					<td>${property.propertyDescription}</td>
					<td>${property.propertyType}</td>
					<td>${property.propertySize}</td>
					<td>${property.propertyAddress}</td>
					<td>${property.sellingPrice}</td>
					<td>${property.numberOfRooms}</td>
					<td>${property.transactionStatus}</td>
					<td><a href="DeleteProperty?id=${property.propertyId}">Remove
							property</a></td>
					<td><a href="EditProperty?id=${property.propertyId}">Edit
							property</a></td>
					<td><a href="addBid?id=${property.propertyId}">Add bid</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
