<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Not Found Error</title>
</head>
<body>
	<div>
		<img src="${pageContext.request.contextPath}/images/BookstoreLogo.png" alt="">
	</div>
	<div align="center">
		<h2>Sorry, the requested page could not be found.</h2>
	</div>
	<div>
		<a href="javascript:history.go(-1);">Go Back</a>
	</div>
</body>
</html>