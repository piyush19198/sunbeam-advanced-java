<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--session.getAttribute("user").getUserDetails() : toString : sent to clnt --%>
	<h5>in candidate list page : User Details :
		${sessionScope.user.userDetails}</h5>
</body>
</html>