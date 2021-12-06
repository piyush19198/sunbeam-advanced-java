<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>in admin page : Hello , ${sessionScope.user.userDetails.name}
	</h5>
	<h5>You are currently logged in as :
		${sessionScope.user.userDetails.role}</h5>
	<h5>
		<a href="logout.jsp">Log Out</a>
	</h5>
</body>
</html>