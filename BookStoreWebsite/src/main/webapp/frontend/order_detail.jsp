f<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Order Detail -  BookStore</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<hr width="60%" />
		<h2>Your Order Detail for Order</h2>
	</div>
	
	<div>
	<c:if test="${message!=null }">
		<h4 class="message"><i>${message}</i></h4>
	</c:if>
	</div>
	<div align="center">
		<h2>Order Overview</h2>
		<table border="1">
	
			<tr>
				<td><b>Order Status:</b></td>
				<td>${ order.orderStatus}</td>
			</tr>
			<tr>
				<td><b>Order Date:</b></td>
				<td>${ order.order_date}</td>
			</tr>
		</table>
	</div>
	<div align="center">
		<h2>Ordered Books</h2>
		<table>
			<tr>
				<th>Index</th>
				<th>Book title</th>
				<th>Author</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${orderDetail.book.title }</td>
					<td>${orderDetail.book.author }</td>
					<td>${orderDetail.book.price }</td>
					<td>${orderDetail.book.quantity }</td>
					<td><fmt:formatNumber value="${orderDetail.book.subtotal}" type="currency"></fmt:formatNumber> </td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" align="right">
				Total:</td>
				<td>
				<b>${order.bookCopies }</b>
				</td>
				<td>
				<b>${order.total}</b>
				</td>
			</tr>
		</table>
	</div>
	<div align="center">
		<a href="">Edit this Order</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="">Delete this Order</a>
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