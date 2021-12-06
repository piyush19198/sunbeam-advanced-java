<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5 align="center" style="color: red">Session ID : <%= session.getId() %></h5>
	<h3>
		Welcome 2 JSP !!!!! @ Server TimeStamp :
		<%=LocalDateTime.now()%></h3>
	<h5>
		<a href="comments.jsp">Test Comments</a>
	</h5>
	<h5>
		<a href="login.jsp">Test Scriptlets n Expressions</a>
	</h5>
	<h5>
		<a href="scopes.jsp">Testing Scopes</a>
	</h5>
	<h5>
		<a href="test.jsp">Testing JSP Declarations</a>
	</h5>
</body>
</html>