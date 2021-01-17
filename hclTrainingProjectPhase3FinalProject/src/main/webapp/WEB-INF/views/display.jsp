<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.task.entity.Task"%>
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
			<h1>Tasks</h1>

			<table class="table table-striped" border='2'>
				<tr class="table table-primary" style="text-align: center">
					<th>Id</th>
					<th>Task Name</th>
					<th>Email</th>
					<th>Severity</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Description</th>
					
					
				</tr>
				<%
					ArrayList<Task> tasks = (ArrayList<Task>) session.getAttribute("tasks");
					for (Task t : tasks) {
				%>
					<tr style="text-align: center">
						<td><%=t.getId()%></td>
						<td><a href="/edit/<%=t.getId()%>"><%=t.getName()%> </a></td>
						<td><%=t.getEmail()%></td>
						<td><%=t.getSeverity()%></td>
						<td><%=t.getStart()%></td>
						<td><%=t.getEnd()%></td>
						<td><%=t.getDescription()%></td>
					</tr>
				<%}%>
			</table>
		</div>
	</div>

</body>
</html>