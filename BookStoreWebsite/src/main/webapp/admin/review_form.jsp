<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:if test="${category!=null}">
 	Edit Review
 </c:if> <c:if test="${category == null }">
Create New Review</c:if></title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">

		<h2>
			<c:if test="${category!=null }">
				Edit Category
			</c:if>
			<c:if test="${category==null }">
				Create New Category
			</c:if>
		</h2>
	</div>
	<div align="center">
		<form action="update_review" method="post">
			<input type="hidden" name="reviewId" value="${review.review_id}" />
			<table class="form">
				<tr>
					<td align="right">Book:</td>
					<td align="left"><input type="text" id="book" name="book"
						size="20" value="${review.book.title}" /></td>
				</tr>
				<tr>
					<td align="right">Rating:</td>
					<td align="left"><input type="text" id="rating" name="rating"
						size="20" value="${review.fating}" /></td>
				</tr>
				<tr>
					<td align="right">Customer:</td>
					<td align="left"><input type="text" id="customer"
						name="customer" size="20" value="${review.customer.fullName}" /></td>
				</tr>
				<tr>
					<td align="right">Headline:</td>
					<td align="left"><input type="text" size="60" id="headline"
						name="headline" size="20" value="${review.headline}" /></td>
				</tr>
				<tr>
					<td align="right">Comment:</td>
					<td align="left"><textarea rows="5" cols="70" name="comment">${review.comment}</textarea>
					</td>
				</tr>



				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save" /> <input type="button" value="Cancel"
						onclick="javascript:history.go(-1)" /></td>

				</tr>
			</table>
		</form>


	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	function validateFormInput() {
		var fieldName = document.getElementById("name");

		if (fieldName.value.length == 0) {
			alert("Category name is required!!")
			fieldName.focus();
			return false;
		}

	}}
</script>

</html>