<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<div align="center">
		
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
				<h2>Review Your Order Details <a href="view_cart">Edit</a></h2>
				<table>
					<tr>
						<th>No</th>
						<th colspan="2">Book</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Subtotal</th>
						<th></th>
					</tr>
					<c:forEach items="${cart.items }" var="item" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>
							<img src="data:image/jpg;base64,${item.key.base64Image}" width="128" height="164"/>
							&nbsp;
							</td>
							<td><span id="book-title">${item.key.title }</span></td>
							<td>${item.key.author}</td>
							<td>
							<input type="text" name="quantity${status.index + 1}" value="${item.value }" size="5" readonly="readonly"/></td>
							<td><fmt:formatNumber value="${item.key.price }" type="currency"></fmt:formatNumber> </td>
							<td><fmt:formatNumber value="${item.value*item.key.price}" type="currency"></fmt:formatNumber> </td>
							
													
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
				<h2>Your Shipping Infomation</h2>
				<form action="place_order" id="orderForm" method="post">
					<table>
						<tr>
							<td>Recipient Name:</td>
							<td><input type="text" name="recipientName" value="${loggedCustomer.fullName}"/></td>
						</tr>
						<tr>
							<td>Recipient Phone:</td>
							<td><input type="text" name="recipientPhone" value="${loggedCustomer.phone}"/></td>
						</tr>
						<tr>
							<td>City:</td>
							<td><input type="text" name="recipientName" value="${loggedCustomer.address.city}"/></td>
						</tr>
						<tr>
							<td>Zip Code:</td>
							<td><input type="text" name="recipientName" value="${loggedCustomer.address.zipcode}"/></td>
						</tr>
						
						<tr>
							<td>Streety Address:</td>
							<td><input type="text" name="address" value="${loggedCustomer.address.address}"/></td>
						</tr>
						
					</table>
					
					<div>
						<h2>Payment</h2>
						Choose your payment method:
						&nbsp;&nbsp;&nbsp;&nbsp;
						<select name="paymentMethod">
							<option value="Cash On Delivery">Cash On Delivery</option>
						</select>
					</div>
				</form>
				<div>
					<table class="normal">
						<tr><td>&nbsp;</td>
						<td></td>
						<td><button type="submit" id="submitButton">Place Order</button></td>
						<td><input type="button" id="clearCart" value="Clear Cart"/></td>
						<td><a href="${pageContext.request.contextPath}/">Continue</a></td>
						</tr>
					</table>
				</div>
			
		</div>
	</c:if>
	
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#orderForm').validate({
				rules:{
					recipientName:"required",
					recipientPhone:"required",
					address:"required",
					city :"required",
					zipcode:"required",
					country:"required"
				},
				messages:{
					recipientName:"Please enter recipient name",
					recipientPhone:"Please enter recipient phone",
					address:"Please enter address",
					city :"Please enter city",
					zipcode:"Please enter zipcode",
					country:"Please enter country"
				}
			})
		});
	</script>
</body>
</html>