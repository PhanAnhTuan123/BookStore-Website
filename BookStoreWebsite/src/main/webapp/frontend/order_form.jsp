f<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Order -  BookStore</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<form action="update_order" method="post" id="orderForm">
	<div align="center">
		<hr width="60%" />
		<h2>Order Detail for Order</h2>
		<h3><a href="category_form.jsp">Create new Order</a></h3>
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
				<td><b>Ordered By</b></td>
				<td>${ order.customer.fullName}</td>
			</tr>
			<tr>
				<td><b>Recipient Name:</b></td>
				<td><input type="text" name="recipientName" value="${ order.recipientName}" size="45"/></td>
			</tr>
			<tr>
				<td><b>Recipient Phone:</b></td>
				<td><input type="text" name="recipientPhone" value="${ order.recipientPhone}" size="45"/></td>
			</tr>
			<tr>
				<td><b>Ship To:</b></td>
				<td><input type="text" name="shippingAddress" value="${ order.shippingAddress}" size="45"/></td>
			</tr>
			<tr>
				<td><b>Payment Method:</b></td>
				
				<td>
					<select name="paymentMethod">
						<option value="Cash on Delivery">Cash on Delivery</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><b>Order Status:</b></td>
				<td>
					<option value="Pending">Pending</option>
					<option value="Processing">Processing</option>
					<option value="Completed">Completed</option>
					<option value="Failed">Failed</option>
					<option value="Refunded">Refunded</option>
					<option value="Voided">Voided</option>
				</td>
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
				<th>Subtotal</th>
				<th><a href="">Add Book</a></th>
			</tr>
			<c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${orderDetail.book.title }</td>
					<td>${orderDetail.book.author }</td>
					<td>${orderDetail.book.price }</td>
					<td>${orderDetail.book.quantity }</td>
					<td><fmt:formatNumber value="${orderDetail.book.subtotal}" type="currency"></fmt:formatNumber> </td>
					<td><a href="remove_book_from_order?id=${orderDetail.book.bookId }">Remove</a></td>
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
		<a href="javascript:showAddBookPopup()">Add Books</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Save"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="Cancel" onclick="javascript:window.location.href=""/>
			
		</div>
</form>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		function showAddBookPopup(){
			var width = 500;
			var left = (screen.width /2) - (width /2);
			var top = (screen.height - heigth)/2;
			window.open('add_book_form','_blank','width=300,height=200,top=100,left=100')
		}	
	</script>
	
</body>
</html>