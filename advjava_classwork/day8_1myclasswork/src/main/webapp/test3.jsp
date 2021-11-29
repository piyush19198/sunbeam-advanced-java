<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>From test3 page : Session ID : ${pageContext.session.id}</h5>
	<h5>User Details from logout page : ${sessionScope.user_dtls}</h5>
	<%--invalidate session pageContext.getSession().invalidate() --%>
	<%-- 	${pageContext.session.invalidate()} --%>
	<%
	session.invalidate();
	%>
	<h5>
		<a href="index.jsp">Visit Again</a>
	</h5>
</body>
</html>