<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book to Order</title>
</head>
<body>
	<div align="center">
<h2>		The book ${book.title } has been added to the order ID ${order.orderId }</h2>
	<input type="button" value="close" onclick="javascript:selft.close()"/>
	
	</div>
	<script>
		window.onunload = function(){
			window.opener.location.reload();
		}
	</script>
</body>
</html>