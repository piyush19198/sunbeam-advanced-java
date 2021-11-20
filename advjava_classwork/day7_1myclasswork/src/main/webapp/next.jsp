<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>From next page....</h5>
	<%--Display all attributes --%>
	<h5>Page Scoped attribute : ${pageScope.nm1}</h5>
	<h5>Request Scoped attribute : ${requestScope.nm2}</h5>
	<h5>Session Scoped attribute : ${sessionScope.nm3}</h5>
	<h5>Application Scoped attribute : ${nm4}</h5>
</body>
</html>