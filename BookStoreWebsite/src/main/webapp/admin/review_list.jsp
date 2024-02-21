<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Review -  BookStore Administration</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<hr width="60%" />
		<h2>Review Management</h2>
		<h3><a href="category_form.jsp">Create new Review</a></h3>
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
				<th>Book</th>
				<th>Rating</th>
				<th>Headline</th>
				<th>Customer</th>
				<th>Review On</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="review" items="${listReviews}" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${review.review_id }</td>
					<td>${review.book.title }</td>
					<td>${review.fating }</td>
					<td>${review.customer.fullName}</td>
					<td>${review.headline }</td>
					<td>${review.comment }</td>
					<td>
						<a href="edit_review?id=${review.review_id}">Edit</a> &nbsp;
						<a href="javascript:confirmDelete(${review.review_id})">Delete</a>
						
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		function confirmDetete(review_id){
	if(confirm("Are you sure you want to delete the category with ID: "+review_id + " ?")){
		window.location = 'delete_review?id='+review_id;
	}
		}
	</script>
	
</body>
</html>