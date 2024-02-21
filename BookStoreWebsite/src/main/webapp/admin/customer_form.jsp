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
<link rel="stylesheet" href="../css/richtext.min.css">
<link rel="stylesheet" href="../js/jquery-ui.css">
<link rel="stylesheet" href="/path/to/font-awesome.min.css">
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">

		<h1 class="pageheading">
			<c:if test="${customer!=null }">
				Edit Customer
			</c:if>
			<c:if test="${customer==null }">
				Create Customer
			</c:if>
		</h1>
	</div>
	<div align="center">
		<c:if test="${customer!=null }">
			<form action="update_customer" method="post" id="customerForm">
				<input type="hidden" name="customerId"
					value="${customer.customerId}" />
		</c:if>
		<c:if test="${customer==null }">
			<form action="create_customer" method="post" id="customerForm">
		</c:if>
		<table class="form">

			<tr>
				<td align="right">E-mail:</td>
				<td align="left"><input type="text" id="email" name="email"
					size="45" value="${customer.email}" /></td>
			</tr>
			<tr>
				<td align="right">Full Name:</td>
				<td align="left"><input type="text" id="fullName"
					name="fullname" size="45" value="${customer.fullname}" /></td>
			</tr>
			<tr>
				<td align="right">Password:</td>
				<td align="left"><input type="password" id="password"
					name="password" size="45" value="${customer.password}" /></td>
			</tr>
			<tr>
				<td align="right">Confirm Password:</td>
				<td align="left"><input type="password" id="confirmPassword"
					name="confirmPassword" size="45" value="${customer.password}" /></td>
			</tr>
			<tr>
				<td align="right">Phone number:</td>
				<td align="left"><input type="text" id="phone" name="password"
					size="20" value="${customer.phone}" /></td>
			</tr>
			<tr>
				<td align="right">Address:</td>
				<td align="left"><input type="text" id="address" name="address"
					size="128" value="${customer.address.address}" /></td>
			</tr>
			<tr>
				<td align="right">City:</td>
				<td align="left"><input type="text" id="city" name="city"
					size="45" value="${customer.address.city}" /></td>
			</tr>

			<tr>
				<td align="right">Zipcode:</td>
				<td align="left"><input type="text" id="zipcode" name="zipcode"
					size="45" value="${customer.address.zipcode}" /></td>
			</tr>
			<tr>
				<td align="right">Country:</td>
				<td align="left"><input type="text" id="country" name="country"
					size="128" value="${customer.address.country}" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr colspan="2" align="center">
				<input type="submit" value="Save" />
				<input type="button" value="Cancel"
					onclick="javascript:history.go(-1)" />

			</tr>
		</table>
		</form>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	$(document).ready(function() {

		$("#customerForm").validate({
			rules : {
				email : {
					required: true,
					email:true
				},
				fullName : "required",
				password : "required",
				confirmPassword: {
				required:true,
				equalTo:"#password"
				},
				phone : "required",
				address : "required",
				city : "required",
				zipcode : "required",
				country : "required"
			},
			messages : {
				email : {
					required:"Please enter e-mail address",
					email:"Please enter a valid e-mail address"
				}
				fullName : "Please enter full name",
				password : "Please enter password",
				confirmPassword: {
					required:"Please confirm password",
					equalTo:"Confirm password does not match password"
					},
				phone : "Please enter phone",
				address : "Please enter address",
				city : "Please enter city",
				zipcode : "Please enter zipcode",
				country : "Please enter country"

			}
		});
	});
</script>

</html>