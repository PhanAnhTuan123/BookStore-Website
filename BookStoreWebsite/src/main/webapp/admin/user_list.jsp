<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Users -  BookStore Administration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<hr width="60%" />
		<h2>Users Management</h2>
		<h3><a href="user_form.jsp">Create new User</a></h3>
	</div>
	
	<div>
	<c:if test="${message!=null }">
		<h4><i>${message}</i></h4>
	</c:if>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Email</th>
				<th>Full Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="user" items="${listUsers}" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${user.userId }</td>
					<td>${user.email }</td>
					<td>${user.fullname }</td>
					<td>
						<a href="">Edit</a> &nbsp;
						<a href="">Delete</a>
						
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>