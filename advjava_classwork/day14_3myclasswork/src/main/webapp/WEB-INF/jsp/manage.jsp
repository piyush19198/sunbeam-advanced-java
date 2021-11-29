<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage</title>
</head>
<body>
	<h2>Tutorial Management</h2>
	<table border="1">
		<thead>
			<tr>
				<td>Id</td>
				<td>Title</td>
				<td>Topic</td>
				<td>Visits</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tut" items="${tutorialList}">
				<tr>
					<td>${tut.id}</td>
					<td><a href="/details?id=${tut.id}">${tut.name}</a></td>
					<td>${tut.topic}</td>
					<td>${tut.visits}</td>
					<td>
						<a href="/edit?id=${tut.id}">Edit</a>
					</td>
				</tr>				
			</c:forEach>
		</tbody>
	</table>
	<a href="/add">Add New Tutorial (Homework)</a>
	<br/>
	${message}
	<br/>
	<a href="/logout">Sign Out</a>
</body>
</html>

