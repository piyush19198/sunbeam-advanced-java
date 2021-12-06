<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 style="color: red;">
		Error Message
		<%=exception.getMessage()%></h5>
		<h5 style="color: red;">
		Error Message Via EL syntax : ${pageContext.exception.message}
		</h5>
		<h5 style="color: red;">
		Error Details Via EL syntax : ${pageContext.exception}
		</h5>
		<h5 style="color: red;">
		Error Causing Page  : ${pageContext.errorData.requestURI}
		</h5>
		<h5 style="color: red;">
		Error Code  : ${pageContext.errorData.statusCode}
		</h5>
		
</body>
</html>