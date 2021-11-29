<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Topic Tutorials</title>
</head>
<body>
	Hello, ${user.name} <hr/>

	<h2>Topic Tutorials</h2>
	<c:forEach var="tut" items="${tutorialList}">
		<a href="details?id=${tut.id}">${tut.name} (${tut.visits})</a> <br/><br/>
	</c:forEach>
</body>
</html>