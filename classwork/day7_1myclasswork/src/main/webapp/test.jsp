<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	String mesg = "some mesg!!!!";

	//can override life cycle methods 
	public void jspInit() {
		System.out.println("in init " + Thread.currentThread());
	}%>
<body>
	<%
	System.out.println("in _jspService " + Thread.currentThread());
	%>
	<h5>
		Message :
		<%=mesg%></h5>
</body>
<%!public void jspDestroy() {
		System.out.println("in destroy " + Thread.currentThread());
	}%>
</html>