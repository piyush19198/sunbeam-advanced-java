<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>From included page</h5>
	<h5>
		Instance var :
		<%=data%></h5>
	<h5>
		Local var :
		<%=mesg%></h5>
	<h5>Page Scoped Attribute : ${pageScope.nm1}</h5>
</body>
</html>