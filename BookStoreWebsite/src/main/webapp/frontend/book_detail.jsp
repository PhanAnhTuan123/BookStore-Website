<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${book.title}-Book Store Website</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<table width="80%" style="">
			<tr>
				<td colspan="3" align="left" height="30px">
					<h2>${book.title}</h2> by ${book.author }
				</td>
				<td></td>
			</tr>
			<tr>
				<td rowspan="2"><img
					src="data:image/jpg;base64,${book.base64Image}" width="240"
					height="300" /></td>
				<td align="left" valign="top"><jsp:include
						page="book_rating.jsp"></jsp:include>
						 <a href="#reviews">${fn:length(book.reviews) } Reviews</a>
						</td>
				<td valign="top" rowspan="2" width="20%">
					<h2>$${book.price}</h2> <br />
					<button type="submit" id="buttonAddtoCart">Add to Cart</button>
				</td>
			</tr>
			<tr>
				<td valign="top" style="text-align: justify;">
					${book.description}</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><h2><a href="" id="reviews">Customer Reviews</a></h2></td>
				<td colspan="2" align="center">
					<button>Write a Customer Review</button>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<table border="0">
						<c:forEach items="${book.reviews }" var="review">
							<tr>
								<td><c:forTokens items="${review.stars}" delims=","
										var="star">
										<c:if test="${star eq 'on' }">
											<img alt="" src="images/rating_on.png" />
										</c:if>
										<c:if test="${star eq 'off' }">
											<img alt="" src="images/rating_off.png" />
										</c:if>
									</c:forTokens> -<b>${review.headline}</b></td>
							</tr>
							<tr>
								<td>by ${review.customer.fullname} on
									${review.getReview_time }</td>
							</tr>
							<tr>
								<td><i> ${review.comment }</i></td>
							</tr>
							<tr>
								<td>%nbsp;</td>

							</tr>


						</c:forEach>
					</table>
				</td>
			</tr>
		</table>

		<div align="left"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function(){

			$("#buttonWriteReview").click(function(){
				window.location = 'write_review?id=' + ${book.bookId};
			});
			$("#buttonAddtoCart").click(function(){
				window.location = 'add_to_cart?book_id='+${book.bookId};
			})
		});
	
	</script>
</body>
</html>