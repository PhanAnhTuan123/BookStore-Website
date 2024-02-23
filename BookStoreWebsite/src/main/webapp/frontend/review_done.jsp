<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Review Posted</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div align="center">
		<form action="post" id="reviewForm">
			<table class="normal" width="60%">
				<tr>
					<td><h2>Your Reviews</h2></td>
					<td>&nbsp;</td>
					<td>${loggedCustomer.fullName}</td>
				</tr>

				<tr>
					<td colspan="3">
						<hr>
					</td>
				</tr>
				<tr>
					<td>
					<span id="book-title">${book.title}</span><br/>
					<img src="data:image/jpg;base64,${book.base64Image}"
						width="240" height="300" /></td>
						<td>
							<h3>Your review has been posted. Thank you!!</h3>
						</td>
				
				</tr>
			</table>
		</form>
		<jsp:include page="footer.jsp"></jsp:include>


		<script type="text/javascript">
			$(document).ready(function() {
				
			});
		</script>
</body>
</html>