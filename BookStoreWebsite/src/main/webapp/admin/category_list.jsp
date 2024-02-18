<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Category -  BookStore Administration</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<hr width="60%" />
		<h2>Category Management</h2>
		<h3><a href="category_form.jsp">Create new Category</a></h3>
	</div>
	
	<div>
	<c:if test="${message!=null }">
		<h4 class="message"><i>${message}</i></h4>
	</c:if>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="category" items="${listCategory}" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${category.categoryId }</td>
					<td>${category.name }</td>
					<td>
						<a href="edit_category?id=${category.categoryId}">Edit</a> &nbsp;
						<a href="javascript:confirmDelete(${category.categoryId})">Delete</a>
						
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		function confirmDetete(categoryId){
	if(confirm("Are you sure you want to delete the category with ID: "+categoryId + " ?")){
		window.location = 'delete_category?id='+cat	egoryId;
	}
		}
	</script>
	
</body>
</html>