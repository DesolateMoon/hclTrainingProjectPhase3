<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.feedback.entity.Product"%>
<%@ page import="com.feedback.entity.Feedback"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product: ${product.getName()}</title>
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
</head>
<body>
	<div class="card text-center">
		<div style="margin: auto;">
			<h1>Product</h1>

			<table class="table table-striped" border='2'>
				<tr class="table table-primary" style="text-align: center">
					<th>Id</th>
					<th>Product Name</th>
				</tr>
				<tr>
					<td>${product.getId()}</td>
					<td>${product.getName()}</td>
				</tr>
			</table>

			<div class="input-group mb-3">
				<form method="post" action="/view/${product.getId()}">
					<h2 class="card-header" style="max-width: 36rem; text-align: center; margin-top: 2%; background-color: #717dd9">Post Review</h2>
					<textarea rows="10" cols="50" name="review"></textarea> <br> 
					<input class="btn btn-primary" type="submit" value="Post">
				</form>
			</div>

			<br> <br>
			<table class="table table-striped" border='2'>
				<tr class="table table-primary" style="text-align: center">
					<th>Reviews</th>
				</tr>
					<%
					List<Feedback> fs = (List<Feedback>) session.getAttribute("fs");
					if (fs == null)
						return;
					for (Feedback f : fs) {
					%>
						<tr>
							<td><%=f.getReview()%></td>
						</tr>
					<%}%>
			</table>
		</div>
	</div>

</body>
</html>