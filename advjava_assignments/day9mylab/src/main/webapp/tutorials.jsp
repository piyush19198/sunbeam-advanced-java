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
	<jsp:useBean id="ttb" class="com.sunbeam.beans.TopicTutorialsBean"/>
	<jsp:setProperty name="ttb" property="topicId" param="topic" />
	${ttb.fetchTopicTutorials()}
	<c:forEach var="tut" items="${ttb.tutorialList}">
		<a href="details.jsp?id=${tut.id}">${tut.name} (${tut.visits})</a> <br/><br/>
	</c:forEach>
</body>
</html>
