<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.feedback.entity.Product"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
	integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
	integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
	crossorigin="anonymous"></script>
<title>Main</title>
</head>
<body>
	<div class="card text-center">
		<div style="margin: auto;">
			<h1>Products</h1>

			<table class="table table-striped" border='2'>
				<tr class="table table-primary" style="text-align: center">
					<th>Id</th>
					<th>Product Name</th>
				</tr>
				<%
					ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
					for (Product p : products) {
				%>
					<tr style="text-align: center">
						<td><%=p.getId()%></td>
						<td><a href="/view/<%=p.getId()%>"><%=p.getName()%> </a></td>
					</tr>
				<%}%>
			</table>
		</div>
	</div>

</body>
</html>