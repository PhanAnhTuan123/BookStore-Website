<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${book.title} - Book Store Website</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">
	<table width="80%" style="border=0;">
		<tr>
		<td colspan="3" align="left" height="30px"> 
			<h2>${book.title}</h2>
		by ${book.author }	
		</td>
		<td></td>
		</tr>
		<tr>
			<td rowspan="2">
			<img src="data:image/jpg;base64,${book.base64Image}" width="240" height="300"/>
			</td>
			<td align="left" valign="top">
			<jsp:include page="book_rating.jsp"></jsp:include>
			</td>
			<td valign="top" rowspan="2" width="20%">
				<h2>$${book.price}</h2>
				<br/>
				<button type="submit">Add to Cart</button>
			</td>
		</tr>
		<tr>
			<td valign="top" style="text-align:justify;">
				${book.description}
			</td>
		</tr>
		<tr><td>&nbsp;</td>
		</tr>
		<tr>
			<td>Customer Reviews</td>
			<td colspan="2" align="center">
				<button>Write a Customer Review</button>
			</td>
		</tr>
	</table>
	
		<div align="left">
		
		
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>