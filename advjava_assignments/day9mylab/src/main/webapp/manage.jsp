<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="manage" class="com.sunbeam.beans.TutorialBean" />
	<%-- <jsp:setProperty  name="manage" property="id" param="id"/> --%>

	${manage.fetchTopicTutorials()}
	<c:forEach var="t" items="${manage.tutorialList}">
		<h4> ID : ${t.id}----Name : <a href="details.jsp?id=${t.id}">${t.name}</a>----Visits : ${t.visits}----Author : ${t.author}----Contents : ${t.contents}----Publish Date : ${t.publishDate} <a href="delete.jsp?id=${t.id}">DELETE</a></h4> <br />
	</c:forEach>
</body>
</html>