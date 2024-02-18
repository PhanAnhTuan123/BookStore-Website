<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<div>
		<img src="../images/BookstoreAdminLogo.png">
	</div>
	<div>
		Welcome, <c:out value="${sessionScope.useremail }"></c:out> | <a href="logout">Logout</a>
	</div>
	<div id="headermenu">
		<div >
			<a href="user_list"><img src="../images/users.png" /><br />Users</a>
		</div>
		<div >
			<a href="list_category"><img src="../images/category.png" /><br />Categories</a>
		</div>
		<div>
			<a href="books"><img src="../images/book.png" /><br />Books</a>
		</div>
		<div>
			<a href="customers"><img src="../images/customer.png" /><br />Customers</a>
		</div>
		<div >
			<a href="reviews"><img src="../images/review.jpg" /><br />Reviews</a>
		</div>
		<div>
			<a href="orders"><img src="../images/orders.png" /><br />Orders</a>
		</div>


	</div>
</div>