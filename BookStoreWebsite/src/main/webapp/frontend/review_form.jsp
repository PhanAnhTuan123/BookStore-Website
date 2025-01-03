<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Review</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
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
				<div id="rateYo"></div>
				<input type="hidden" id="rating" name="rating" />
				<input type="hidden" id="bookId" name="bookId" value="${book.bookId}"/>
				
				<br/>
					<input type="text" name="headline" size="60" placeholder="Headline or summary for your review(required)"/>
					<br/>
					<br/>
					<textarea rows="70" cols="10" name="comment" placeholder="Write your review details..."></textarea>
				</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
					<button type="submit">Submit</button>
					&nbsp;&nbsp;
					<button id="buttonCancel">Cancel</button>
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="footer.jsp"></jsp:include>


		<script type="text/javascript">
			$(document).ready(function() {
				$("#rateYo").rateYo({
				    starWidth: "40px",
				    fullStar: true,
				    onSet: function(rating,rateYoInstance){
				    	$("#rating").val(rating);
				    }
				  });
				
				$("#reviewForm").validate({
					rules : {
						headline : "required",
						comment : "required",
					},
					messages : {
						email : {
							headline : "Please enter email",
							comment : "Please enter an valid email address"
						},
						password : "Please enter password"
					}
				});
				$("#buttonCancel").click(function(){
					history.go(-1);
				});
			});
		</script>
</body>
</html>