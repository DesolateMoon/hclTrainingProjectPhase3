<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>
</head>
<body>
	ID: ${user.getId()} </br>
	Name: ${user.getName()} </br>
	<a href="/edit?id=${user.getId()}">Edit</a>
	<a href="/search">Go back</a>

</body>
</html>