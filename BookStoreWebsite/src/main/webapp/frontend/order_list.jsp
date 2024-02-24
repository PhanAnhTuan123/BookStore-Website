<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>		
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My  Order History -  BookStore</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<hr width="60%" />
		<h2>My Orders</h2>
	</div>
	<c:if test="${fn:length(listOrders)== 0 }">
	<h3>You have not placed any orders.</h3>
	</c:if>
	<c:if test="${fn:length(listOrders)> 0 }">
	
	
	
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
				<th> Quantity</th>
				<th>Total Amount</th>
				<th>Order Date</th>
				<th>Status</th>
				<th>Actions</th>
				
			</tr>
			<c:forEach var="order" items="${listOrder}" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${order.orderId }</td>
					<td>${order.getBookCopies }</td>
					<td><fmt:formatNumber value=" ${order.total}" type="currency"></fmt:formatNumber></td>
					<td>${order.order_date}</td>
					<td>${order.status}</td>
					<td>
						<a href="show_order_detail?id=${order.orderId}">Details</a> &nbsp;
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</c:if>

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