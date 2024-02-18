<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookStore Administration</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">

		<h1 class="pageheading">
			<c:if test="${user!=null }">
				Edit user
			</c:if>
			<c:if test="${user==null }">
				Create user
			</c:if>
		</h1>
	</div>
	<div align="center">
		<c:if test="${user!=null }">
			<form action="update_user" method="post" id="userForm">
				<input type="hidden" name="userId" value="${user.userId}" />
		</c:if>
		<c:if test="${user==null }">
			<form action="create_user" method="post" id="userForm">
		</c:if>
		<table class="form">
			<tr>
				<td align="right">Email:</td>
				<td align="left"><input type="text" id="email" name="email"
					size="20" value="${user.email}" /></td>
			</tr>
			<tr>
				<td align="right">FullName:</td>
				<td align="left"><input type="text" id="fullname"
					name="fullname" size="20" value="${user.fullname}" /></td>
			</tr>
			<tr>
				<td align="right">Password:</td>
				<td align="left"><input type="text" id="password"
					name="password" size="20" value="${user.password}" /></td>
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
		$("#userForm").validate({
			rules : {
				email : {
					required:true,
					email:true
				},
				fullname : "required",
				password : "required",
			},
			messages : {
				email : {
					required:"Please enter email",
					email:"Please enter an valid email address"
				},
				fullname : "Please enter full name",
				password : "Please enter password"
			}
		});
	});
</script>

</html>