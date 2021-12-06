<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 align="center" style="color: red">
		Session ID :
		<%=session.getId()%></h5>
	<h5>
		Hello ,
		<%
	//JSP scriptlet
	out.print(request.getParameter("name"));
	%>
	</h5>

	<h5>
		Your Password :
		<%
	out.print(request.getParameter("pass"));
	%>
	</h5>
	<hr>
	<h3>Request Parameters via JSP Expression</h3>
	<h5>
		Hello ,
		<%=request.getParameter("name")%></h5>
	<h5>
		Password : 
		<%=request.getParameter("pass")%></h5>
		<hr/>
		<h4>Using EL Syntax</h4>
		<h5>param : ${param}</h5>

</body>
</html>