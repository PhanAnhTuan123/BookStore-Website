<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result for ${keyword} - Book Store Website</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
		<c:if test="${fn:length(result) ==0 }">
			<h2>No Result for ${keyword }</h2>
		</c:if>
		<c:if test="${fn:length(result) >0 }">


			<br>
			<br>
			<h3>
				</h1>
				<center>
					<h2>Result for ${keyword }:</h2>
				</center>
				<div align="center" style="width: 80%; margrin: 0 auto;">
					<c:forEach items="${result}" var="book">
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
							<p>${fn:substring( book.description,0,100)}...</p>
						</div>
				</div>
				<div style="display: inline-block; margin: 20px;">
					<h3>
						<b>$${book.price}</b>
					</h3>
					<h3>
						<a>Add to Cart</a>
					</h3>
				</div>
				</c:forEach>
		</c:if>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>