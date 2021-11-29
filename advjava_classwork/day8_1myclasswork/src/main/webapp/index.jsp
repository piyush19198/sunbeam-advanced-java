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
<h5>From index page : Session ID : ${pageContext.session.id}</h5>
<h5> Session Expiration Timeout : ${pageContext.session.maxInactiveInterval}</h5>
<h6>Server Time : <%= LocalDateTime.now() %></h6>
	<h5>
		<a href="login.jsp">Testing URL Rewriting</a>
	</h5>
	<h5>
		<a href="test4.jsp">Testing Error Handling in JSP</a>
	</h5>
	<h5>
		<a href="test5.jsp">Testing include directive</a>
	</h5>
	<h5>
		<a href="test7.jsp?pid=101&name=mango&price=50">Testing forward action</a>
	</h5>
</body>
</html>