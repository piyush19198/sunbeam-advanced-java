<%@page import="com.sunbeam.pojos.Topic"%>
<%@page import="com.sunbeam.beans.TopicsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Topics</title>
</head>
<body>
	<%--
		TopicsBean tb = new TopicsBean();
		tb.fetchTopics();
		for(Topic t : tb.getTopicList())
			out.println("<input type='radio' name='topic' value='"+t.getId()+"'> " + t.getName());
	--%>
	
	<form method="post" action="tutorials.jsp">
		<jsp:useBean id="tb" class="com.sunbeam.beans.TopicsBean"/>
		${tb.fetchTopics()}
		<c:forEach var="t" items="${tb.topicList}">
			<input type="radio" name="topic" value="${t.id}"/> ${t.name}<br/>
		</c:forEach>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>