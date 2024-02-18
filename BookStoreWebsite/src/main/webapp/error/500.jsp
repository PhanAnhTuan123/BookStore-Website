<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Internal Server Error</title>
</head>
<body>
	<div>
		<img src="${pageContext.request.contextPath}/images/BookstoreLogo.png" alt="">
	</div>
	<div align="center">
		<h2>Sorry, the server has encountered an error while your request.</h2>
		<h3>please check back later or contact our adminstrators</h3>
	</div>
	<div>
		<a href="javascript:history.go(-1);">Go Back</a>
	</div>
</body>
</html>