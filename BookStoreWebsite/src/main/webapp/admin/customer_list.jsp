<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Customer - BookStore Administration</title>
<link rel="stylesheet" href="../css/style.css">

<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<hr width="60%" />
		<h1 class="pageheading">Customer Management</h1>
		<h3>
			<a href="customer_form.jsp">Create new Customer</a>
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
				<th>Email</th>
				<th>Full Name</th>
				<th>City</th>
				<th>Country</th>
				<th>Register Date</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="custommer" items="${listCustomer}" varStatus="status">
				<tr>
					<td>${status.index +1 }</td>
					<td>${custommer.customerId }</td>
					<td>${custommer.email }</td>
					<td>${custommer.address.city }</td>
					<td>$ ${custommer.address.country }</td>
					<td>$ ${custommer.register_date}</td>
					
					<td><a href="edit_customer?id=${customer.customerId}">Edit</a> &nbsp; <a
						href="javascript:void(0)" class="deleteLink" id="${customer.customerId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
	<script>
	$(document).ready(function(){
		$(".deleteLink").each(function(){
			$(this).on("click",function(){
				cutomerId = $(this).attr("id");
				if (confirm("Are you sure you want to delete the customer with ID: "
						+ customerId + " ?")) {
					window.location = 'delete_customer?id=' + customerId;
				
				}
			});
		});
	});

	</script>

</body>
</html>