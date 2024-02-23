<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<div align="center">
		<h2>Shopping Cart Detail</h2>
		<c:if test="${message !=null }">
			<div>
				<h4>${message}</h4>
			</div>
		</c:if>

	<c:set var="cart" value="${sessionScope['cart']}"></c:set>

	<c:if test="${cart.totalItems ==0 }">
		<h2>There's no items in your cart</h2>
	</c:if>
	<c:if test="${cart.totalItems >0 }">
		<div>
			<form action="update_cart" method="post" id="cartForm">
				<table>
					<tr>
						<th>No</th>
						<th colspan="2">Book</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Subtotal</th>
						<th>
							<a href=""><b>Clear Cart</b></a>
						</th>
					</tr>
					<c:forEach items="${cart.items }" var="item" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>
							<img src="data:image/jpg;base64,${item.key.base64Image}" width="128" height="164"/>
							&nbsp;
							</td>
							<td><span id="book-title">${item.key.title }</span></td>
							<td>
							<input type="hidden" name="bookId" value="${item.key.bookId}"/>
							<input type="text" name="quantity${status.index + 1}" value="${item.value }" size="5"/></td>
							<td><fmt:formatNumber value="${item.key.price }" type="currency"></fmt:formatNumber> </td>
							<td><fmt:formatNumber value="${item.value*item.key.price}" type="currency"></fmt:formatNumber> </td>
							<td><a href="remove_from_cart?book_id=${item.key.bookId }">Remove</a></td>
													
						</tr>
						
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td><b>${cart.totalQuantity }Book(s)</b></td>
						<td>Total:</td>
						<td span="2"><fmt:formatNumber value="${cart.totalAmount}" type="currency"></fmt:formatNumber></td>
					</tr>
					
				</table>
				<div>
					<table class="normal">
						<tr><td>&nbsp;</td></tr>
						<td></td>
						<td><button type="submit" id="submitButton">Update</button></td>
						<td><input type="button" id="clearCart" value="Clear Cart"/></td>
						<td><a href="${pageContext.request.contextPath}/">Continue Shopping</a></td>
						<td><a href="">Checkout</a></td>
					</table>
				</div>
			</form>
		</div>
	</c:if>
	
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	
	
	<script type="text/javascript">
		$(document).ready(function() {
			$("#clearCart").click(function(){
				window.location = 'clear_cart' 
			});
			$("#cartForm").validate({
				rules : {
					<c:forEach items="${cart.items}" var="item" varStatus="status">
						quantity${status.index + 1}:{required:true,number:true,min:1}
					</c:forEach>
				},
				messages : {
					<c:forEach items="${cart.items}" var="item" varStatus="status">
					quantity${status.index + 1}:{required:"Please enter quantity",number:"Quantity must be a number",min:"Quantity must be greater than 0."}
				</c:forEach>
				}
			});
		});
	</script>
</body>
</html>