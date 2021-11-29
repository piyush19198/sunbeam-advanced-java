<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int result = 100 / 0;//method local var : _jspService
	%>
	<h5>
		Result :
		<%=result%></h5>
</body>
</html>