<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Order -  BookStore Administration</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<hr width="60%" />
		<h2>Order Management</h2>
		<h3><a href="category_form.jsp">Create new Order</a></h3>
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
				<th>Order ID</th>
				<th>Ordered by</th>
				<th>Book Copies</th>
				<th>Total</th>
				<th>Payment Methods</th>
				<th>Status</th>
				<th>Order Date</th>
				<th>Actions</th>
				
			</tr>
			<c:forEach var="order" items="${listOrder}" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${order.orderId }</td>
					<td>${order.customer.fullName }</td>
					<td>${order.getBookCopies }</td>
					<td><fmt:formatNumber value=" ${order.total}" type="currency"></fmt:formatNumber></td>
					<td>${order.paymentMethod }</td>
					<td>${order.status}</td>
					<td>${order.order_date}</td>
					
					<td>
						<a href="view_order?id=${order.orderId}">Details</a> &nbsp;
						<a href="edit_order?id=${order.orderId}">Edit</a> &nbsp;
						<a href="javascript:confirmDelete(${order.orderId})">Delete</a>
						
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		function confirmDetete(orderId){
	if(confirm("Are you sure you want to delete the category with ID: "+review_id + " ?")){
		window.location = 'delete_order?id='+orderId;
	}
		}
	</script>
	
</body>
</html>