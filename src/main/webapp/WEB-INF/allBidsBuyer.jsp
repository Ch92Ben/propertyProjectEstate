<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/pure-min.css">
<link rel="stylesheet" href="css/custom.css">
<title>My bids</title>
</head>
<body>
	<%@ include file="buyerMenu.jsp"%>
	<h2>My bids</h2>
	<span class="form-error">${errorMessage}</span>
	<br>
	<table class="pure-table pure-table-bordered pure-table-striped">
		<thead>
			<tr>
				<th>Property address</th>
				<th>Bid amount</th>
				<th>Bid date</th>
				<th>Bid status</th>
				<th colspan="1" style="background-color: red">Property actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bids}" var="bid">
				<tr>
					<td>${bid.bidId}</td>
					<td>${bid.bidAmount}</td>
					<td>${bid.bidDate}</td>
					<td>${bid.bidStatus}</td>
					<td><a href="SignPaperworkBuyer?id=${bid.bidId}">Sign
							paperwork</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
