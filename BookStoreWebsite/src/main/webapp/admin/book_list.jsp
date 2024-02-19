<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Books - BookStore Administration</title>
<link rel="stylesheet" href="../css/style.css">

<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<hr width="60%" />
		<h1 class="pageheading">Books Management</h1>
		<h3>
			<a href="new_book.jsp">Create new Book</a>
		</h3>
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
				<th>Image</th>
				<th>Title</th>
				<th>Author</th>
				<th>Category</th>
				<th>Price</th>
				<th>Last Updated</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="book" items="${listBook}" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${book.book_id }</td>
					<td>
						<img src="data:image/jpg;base64,${book.base64Image}" width="84" height="110"/>
					</td>
					<td>${book.title }</td>
					<td>${book.author }</td>
					<td>${book.description }</td>
					<td>${book.isbn }</td>

					<td>$ ${book.price }</td>
					<td>value="<fmt:formatDate pattern="MM/dd/yyyy" value="${book.publish_date }"/>" </td>
					<td>value="<fmt:formatDate pattern="MM/dd/yyyy" value=" ${book.last_update_time }"/>" </td>
					<td><a href="edit_book?id=${book.book_id}">Edit</a> &nbsp; <a
						href="javascript:void(0)" class="deleteLink" id="${book.book_id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
	<script>
	$(document).ready(function(){
		$(".deleteLink").each(function(){
			$(this).on("click",function(){
				userId = $(this).attr("id");
				if (confirm("Are you sure you want to delete the book with ID: "
						+ bookId + " ?")) {
					window.location = 'delete_book?id=' + bookId;
				
				}
			});
		});
	});

	</script>

</body>
</html>