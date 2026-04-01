<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="formBody">
		<h2>
			<strong>My Bids</strong> <br> <em>${save } </em>
		</h2>
		<div class="table">
			<table>
				<tr>

					<th>Product</th>

					<th>Bid Amount</th>

				</tr>
				<c:forEach items="${bids }" var="bid">
					<tr>
						<td>1</td>
						<td>${bid.Property.propertyId}</td>
						<td>${bid.bidAmount}</td>
						<td><a href='<c:url value="/bid/delete/${bid.bidId }"/>'>Delete
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>





