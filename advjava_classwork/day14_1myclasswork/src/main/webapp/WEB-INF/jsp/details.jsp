<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
	Hello, ${uname} <hr/>

	<h2>Tutorial</h2>
	<h4>${tutorial.name}</h4>
	<h5>${tutorial.author}</h5>
	<div>
		Published: ${tutorial.publishDate}
	</div>
	<div>
		Visits: ${tutorial.visits}
	</div>
	<hr/>
	<div>
		${tutorial.contents}
	</div>
	<c:choose>
		<c:when test="${role == 'admin'}">
			<a href="/manage">Manage</a>	
		</c:when>
		<c:otherwise>
			<a href="/topicsurl">Topics</a>
		</c:otherwise>
	</c:choose>
	
	<a href="logout">Sign Out</a>
</body>
</html>
