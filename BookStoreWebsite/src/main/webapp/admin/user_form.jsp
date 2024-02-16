<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookStore Administration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		
		<h2>Create New User</h2>
	</div>
	<div align="center">
		
		<form action="create_user" method="post" onclick="return validateFormInput">
			<table>
			<tr>
				<td align="right">Email:</td>
				<td align="left"><input type="text" id="email" name="email" size="20" /></td>
			
				<td align="right"> FullName:</td>
				<td align="left"><input type="text" id="fullname" name="fullname" size="20" /></td>
			
				<td align="right">Password:</td>
				<td align="left"><input type="text" id="password" name="password" size="20" /></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr colspan="2" align="center">
				<input type="submit" value="Save"/>
				<input type="button" value="Cancel" onclick="javascript:history.go(-1)"/>
				
			</tr>
		</table>
		</form>
	</div>
	

	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	function validateFormInput(){
		var fieldEmail = document.getElementById("email");
		var fieldFullName = document.getElementById("fullname");
		var fieldPassword = document.getElementById("password");
		if(fieldEmail.value.length ==0){
			alert("Email is required!!")
			fieldEmail.focus();
			return false;
		}
		
		if(fieldFullname.value.length ==0){
			alert("Fullname is required!!")
			fieldEmail.focus();
			return false;
		}
		
		if(fieldPassword.value.length ==0){
			alert("Password is required!!")
			fieldEmail.focus();
			return false;
		}
		
	}
</script>

</html>