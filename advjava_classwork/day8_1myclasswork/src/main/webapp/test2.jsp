<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>From test2 page : Session ID : ${pageContext.session.id}</h5>
	<%--Display user details from session scope  --%>
	<h5>User Details : ${sessionScope.user_dtls}</h5>
	<%--logout link --%>
	<%
	String encodedURL = response.encodeURL("test3.jsp");
	%>
	<h5>
		<a href=<%= encodedURL%>>Log Me Out</a>
	</h5>
</body>
</html>