<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Users -  BookStore Administration</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<hr width="60%" />
		<h1 class="pageheading">Users Management</h1>
		<h3><a href="user_form.jsp">Create new User</a></h3>
	</div>
	
	<div>
	<c:if test="${message!=null }">
		<h4 class="message">${message}</h4>
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
						<a href="edit_user?id=${user.id}">Edit</a> &nbsp;
						<a href="javascript:confirmDelete(${user.userId})">Delete</a>
						
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		function confirmDetete(userId){
	if(confirm("Are you sure you want to delete the user with ID: "+userId + " ?")){
		window.location = 'delete_user?id='+userId;
	}
		}
	</script>
	
</body>
</html>