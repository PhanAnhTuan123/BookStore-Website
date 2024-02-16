<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookStore Administration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">

		<h2>
			<c:if test="${user!=null }">
				Edit user
			</c:if>
			<c:if test="${user==null }">
				Create user
			</c:if>
		</h2>
	</div>
	<div align="center">
		<c:if test="${user!=null }">
			<form action="update_user" method="post"
				onclick="return validateFormInput">
				<input type="hidden" name="userId" value="${user.userId}"/>
		</c:if>
		<c:if test="${user==null }">
			<form action="create_user" method="post"
				onclick="return validateFormInput">
		</c:if>
		<table>
			<tr>
				<td align="right">Email:</td>
				<td align="left"><input type="text" id="email" name="email"
					size="20" value="${user.email}" /></td>

				<td align="right">FullName:</td>
				<td align="left"><input type="text" id="fullname"
					name="fullname" size="20" value="${user.fullname}" /></td>

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
	function validateFormInput() {
		var fieldEmail = document.getElementById("email");
		var fieldFullName = document.getElementById("fullname");
		var fieldPassword = document.getElementById("password");
		if (fieldEmail.value.length == 0) {
			alert("Email is required!!")
			fieldEmail.focus();
			return false;
		}

		if (fieldFullname.value.length == 0) {
			alert("Fullname is required!!")
			fieldEmail.focus();
			return false;
		}

		if (fieldPassword.value.length == 0) {
			alert("Password is required!!")
			fieldEmail.focus();
			return false;
		}

	}
</script>

</html>