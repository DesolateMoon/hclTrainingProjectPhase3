<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.task.entity.Task"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task: ${task.getName()}</title>
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
<title>Edit</title>
</head>
<body>
	<div style="max-width: 500px; margin: auto; border: 1px solid black; padding: 10px; margin-top: 30px; height: 535px; position: relative;"
		class="card text-dark bg-light mb-3">
		<div>
			<h2 style="margin-top: 3%"card-title">Edit task</h2>

			<form class="form-group" method="post">
				<label class="card-header">Task Name:</label> 
				<input class="form-control" type="text" name="name" value=${task.getName()} required="required">
				
				Start Date: <input type= "date" name="start" value=${task.getStart()} required="required"> </br>
				End Date: <input type= "date" name="end" value=${task.getEnd()} required="required"> </br>
				
				<label class="card-header">Description:</label> 
				<input class="form-control" type="text" name="description" value=${task.getDescription()} required="required">
				<label class="card-header">Email:</label> 
				<input class="form-control" type="text" name="email" value=${task.getEmail()} required="required">
				<label class="card-header">Severity:</label> 
				<select name="severity" required="required">
					<option value="">--</option>
					<option value="High">High</option>
					<option value="Medium">Medium</option>
					<option value="Low">Low</option>
				</select> </br>
				
				</br> 
				<input class="btn btn-primary" type="submit" value="Save">
			</form>
			<form class="form-group" method="post" action="/delete/${task.getId()}">
				<input class="btn btn-danger" type="submit" value="Delete">
			</form>
		</div>
	</div>

</body>
</html>