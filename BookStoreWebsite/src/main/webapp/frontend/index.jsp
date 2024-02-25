<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phan Anh Tuan - Book Store Website</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<br> <br>
		<h3>
			This is main content:
			</h1>
			<h2>News Books:</h2>
			<div align="center" style="width: 80%; margrin: 0 auto;">
				<c:forEach items="${listNewBooks}" var="book">
					<div style="display: inline-block; margin: 10px;">
						<div>
							<a href="view_book?id=${book.bookId}"> <img
								src="data:image/jpg;base64,${book.base64Image}" width="128"
								height="164" />
							</a>
						</div>
						<a href="view_book?id=${book.bookId}"> <b>${book.title}</b>
						</a>
					</div>
					 
					<div>
					<c:forTokens items="${book.ratingStars}" delims="," var="star">
						<c:if test="${star eq 'on' }">
							<img alt="" src="images/rating_on.png" />
						</c:if>
							<c:if test="${star eq 'off' }">
							<img alt="" src="images/rating_off.png" />
						</c:if>
										<c:if test="${star eq 'half' }">
							<img alt="" src="images/rating_half.png" />
						</c:if>
		
					</c:forTokens>
					</div>
						<div>
						<i>by ${book.author}</i>
					</div>
						<div>
						<b>$ ${book.price}</b>
					</div>
				</c:forEach>
				
				
			</div style="clear:both;">
			<h2>Best Selling Books:</h2>
			<jsp:include page="book_group.jsp"></jsp:include>
				</div>
			<div style="clear: both;">
				<h2>Most-favored Books:</h2>
				<c:forEach items="${mostFavoredBooks}" var="book">
					<div style="display: inline-block; margin: 10px;">
						<div>
							<a href="view_book?id=${book.bookId}"> <img
								src="data:image/jpg;base64,${book.base64Image}" width="128"
								height="164" />
							</a>
						</div>
						<a href="view_book?id=${book.bookId}"> <b>${book.title}</b>
						</a>
					</div>
					 
					<div>
					<c:forTokens items="${book.ratingStars}" delims="," var="star">
						<c:if test="${star eq 'on' }">
							<img alt="" src="images/rating_on.png" />
						</c:if>
							<c:if test="${star eq 'off' }">
							<img alt="" src="images/rating_off.png" />
						</c:if>
										<c:if test="${star eq 'half' }">
							<img alt="" src="images/rating_half.png" />
						</c:if>
		
					</c:forTokens>
					</div>
						<div>
						<i>by ${book.author}</i>
					</div>
						<div>
						<b>$ ${book.price}</b>
					</div>
				</c:forEach>
				
			</div>
			<br> <br>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>