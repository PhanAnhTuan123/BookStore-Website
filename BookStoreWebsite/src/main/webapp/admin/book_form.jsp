<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookStore Administration</title>
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../js/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center">

		<h1 class="pageheading">
			<c:if test="${book!=null }">
				Edit Book
			</c:if>
			<c:if test="${book==null }">
				Create Book
			</c:if>
		</h1>
	</div>
	<div align="center">
		<c:if test="${book!=null }">
			<form action="update_book" method="post" id="bookForm">
				<input type="hidden" name="userId" value="${user.userId}" />
		</c:if>
		<c:if test="${book==null }">
			<form action="create_book" method="post" id="bookForm" enctype="multipart/form-data">
		</c:if>
		<table class="form">
			<tr>
				<td>Category</td>
				<td>
					<select name="category">
						<c:forEach items="${listCategory}" var="category">
							<option value="${category.categoryId}"/>
							${category.name}
						</c:forEach>
					</select>
				</td>
			</tr>
		
			<tr>
				<td align="right">Title:</td>
				<td align="left"><input type="text" id="title" name="title"
					size="20" value="${book.title}" /></td>
			</tr>
			<tr>
				<td align="right">Author:</td>
				<td align="left"><input type="text" id="author"
					name="author" size="20" value="${book.author}" /></td>
			</tr>
			<tr>
				<td align="right">Book Image:</td>
				<td align="left">
				
				<input type="file" id="bookImage" name="bookImage"
					size="20" />
				<img id="thumbnail" alt="Image Preview" style="width:20%; nargin-top:10px;"/>	
					</td>
			</tr>
			<tr>
				<td align="right">Price:</td>
				<td align="left"><input type="text" id="price" name="price"
					size="20"  value="${book.price}"/></td>
			</tr>
			<tr>
				<td align="right">Description:</td>
				<td align="left">
					<textarea rows="5" cols="50" id="description" name="description"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">ISBN:</td>
				<td align="left"><input type="text" id="email" name="email"
					size="20" value="${book.isbn}" /></td>
			</tr>
			
			<tr>
				<td align="right">Publist Date:</td>
				<td align="left"><input type="text" id="publistDate" name="publistDate"
					size="20" value="${book.publish_date}" /></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr colspan="2" align="center">
				<input type="submit" value="Save" />
				<input type="button" value="Cancel"
					onclick="javascript:history.go(-1)" />

			</tr>
		</table>
		</form>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#publishDate").datepicker();
		$("#bookImage").change(function(){
			showImageThumbnail(this);
		});
		
		$("#bookForm").validate({
			rules : {
				category:"required",
				title:"required",
				author:"required",
				isbn : "required",
				bookImage : "required",
				publistDate : "required",
				price: "required",
				description:"required"
			},
			messages : {
				category:"Please select a category for the book",
				title : "Please enter title",
				author : "Please enter author",
				isbn : "Please enter isbn",
				bookImage : "Please choose bookImage",
				publistDate : "Please enter publistDate",
				price : "Please enter price",
				description : "Please enter description",
				
			}
		});
	});
	function showImageThumbnail(FileInput){
		var file = FileInput.files[0];
		var reader = new FileReader();
		reader.onload = function(e){
			$('#thumbnail').attr('src',e.target.result);
		};
		reader.readAsDataURL(file);
		
	}
</script>

</html>