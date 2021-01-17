<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
	integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
	integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
	crossorigin="anonymous"></script>

<title>Login</title>
</head>
<body>
	<div style="max-width: 500px; margin: auto; border: 1px solid black; padding: 10px; margin-top: 30px; height: 325px; position: relative;"
		class="card text-dark bg-light mb-3">
		<div>
			<h2 style="margin-top: 2%"card-title">Login</h2>
			<form class="form-group" method="post" action="add">
				<label class="card-header">Email:</label> 
				<input class="form-control" type="text" name="email" required="required">
				<label class="card-header">Password:</label> 
				<input class="form-control" type="password" name="password" required="required">
				</br> 
				<input class="btn btn-primary" type="submit" value="Login">
			</form>
		</div>
	</div>
</body>
</html>