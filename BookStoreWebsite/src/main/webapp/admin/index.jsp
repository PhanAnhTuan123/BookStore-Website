<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookStore Administration</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<hr width="60%" />
		<h2>Administrative Dashboard</h2>
	</div>
	<div align="center">
		<hr width="60%" />
		<h2>Quick Actions:</h2>
		<b> <a href="new_book">New Book</a> &nbsp; <a href="user_form.jsp">New
				User</a> &nbsp; <a href="category_form.jsp">New Category</a> &nbsp; <a
			href="customer_form.jsp">New Customer</a> &nbsp;
		</b>
	</div>
	<div align="center">
		<hr width="60%" />
		<h2 class="pageheading">Recent Sales</h2>
		<table>
			<tr>
				<th>Order ID</th>
				<th>Ordered By</th>
				<th>Book Copies</th>
				<th>Total</th>
				<th>Payment Method</th>
				<th>Status</th>
				<th>Order Date</th>
			</tr>
			<c:forEach items="${listMostRecentSales}" var="order" varStatus="status">
				<td><a href="view_order?id=${order.orderID }">${order.orderID }</a></td>
				<td>${order.customer.fullname }</td>
				<td>${order.bookCopies }</td>
				<td><fmt:formatNumber value="${order.total }" type="currency"></fmt:formatNumber></td>
				<td>${order.payment_method }</td>
				<td>${order.status }</td>
				<td>${order.order_date }</td>
			</c:forEach>
		</table>
	</div>

	<div align="center">
		<h2 class="pageheading">Recent Reviews</h2>
		<table	border="1">
			<tr>
				<th>Book</th>
				<th>Rating</th>
				<th>Headline</th>
				<th>Customer</th>
				<th>Review On</th>
			</tr>
			<c:forEach items="${listMostRecentReviews}" var="status">
				<tr>
					<td>
						${review.book.title}						
					</td>
					<td${review.fating }></td>
					<td> <a href="edit_review?id=${review.reviewId}">${review.headline }</a></td>
					<td><${review.customer.fullName }</td>
					<td>${review.review_time }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div align="center">
		<hr width="60%" />
		<h2 class="pageheading">Statistics</h2>
		Total Users: ${ totalUsers} &nbsp;&nbsp;&nbsp;&nbsp;
		Total Books: ${ totalBooks} &nbsp;&nbsp;&nbsp;&nbsp;
		Total Customer: ${ totalCustomers} &nbsp;&nbsp;&nbsp;&nbsp;
		Total Reviews: ${ totalReviews} &nbsp;&nbsp;&nbsp;&nbsp;
		Total Order: ${ totalOrders} &nbsp;&nbsp;&nbsp;&nbsp;
		
		<hr width="60%" />
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>