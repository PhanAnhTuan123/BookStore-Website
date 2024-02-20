<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phan Anh Tuan - Book Store Website</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<br>
		<br>
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

					<div>Rating*****</div>
					<div>
						<i>by ${book.author}</i>
					</div>
					<div>
						<b>$ ${book.price}</b>
					</div>
				</c:forEach>
			</div style="clear:both;">
			<h2>Best Selling Books:</h2>
			<div style="clear:both;">
				<h2>Most-favored Books:</h2>
			</div>
			<br>
			<br>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>