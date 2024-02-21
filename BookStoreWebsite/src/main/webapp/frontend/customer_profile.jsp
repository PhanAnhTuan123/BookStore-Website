<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Profile - BookStore</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<br/>
		<h2><i>Welcome, {loggedCustomer.fullName}</i></h2>
		<br/>
	</div>
	<table class="customer">
		<tr>
			<td><b>E-mail Address:</b></td>
			<td>${loggedCustomer.email}</td>
		</tr>
		<tr>
			<td><b>Full Name:</b></td>
			<td>${loggedCustomer.fullName}</td>
		</tr>
		<tr>
			<td><b>Phone:</b></td>
			<td>${loggedCustomer.phone}</td>
		</tr>
		
		<tr>
			<td><b> Address:</b></td>
			<td>${loggedCustomer.address.address}</td>
		</tr>
		
		<tr>
			<td><b>City:</b></td>
			<td>${loggedCustomer.adddress.city}</td>
		</tr>
		
		<tr>
			<td><b>Zipcode:</b></td>
			<td>${loggedCustomer.address.zipcode}</td>
		</tr>
		<tr>
			<td><b>Country:</b></td>
			<td>${loggedCustomer.address.country}</td>
		</tr>
		<tr>&nbsp;</tr>
		<tr>
			<td colspan="2" align="center"><b><a href="edit_profile">Edit My Profile</a></b></td>
		</tr>
	</table>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>