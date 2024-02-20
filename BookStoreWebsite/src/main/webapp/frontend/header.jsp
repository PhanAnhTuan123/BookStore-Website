<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<div>
		<img src="../images/BookstoreLogo.png">
	</div>
	<div>
	<form action="search" method="get">
		<input type="text" name="keyword" size="50" /> <input type="submit"
			value="Search" /> 
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
			href="login.jsp">Sign in</a> <a href="">Register</a> <a href="">Cart</a>
			</form>
	</div>
	<div>%nbsp;</div>
	<div>
		<c:forEach var="category" items="${listCategory} varStatus="status">
			<a href="view_category?id=${category.categoryId}">
			<font size="+1"><b><c:out value="${category.name}" /> </b></font> |
			</a>
			<c:if test="${not status.last }">
			&nbsp; | &nbsp;
			</c:if>
		</c:forEach>
	</div>
</div>
