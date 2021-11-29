<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!
 int data=1234;//data : instance var
%>
<body>
<h5>From 1st page....</h5>
<%
 //local var
 String mesg="hello";
//page scoped attribute :
	pageContext.setAttribute("nm1", 34567);
%>
<%-- include contents of next page @ translation time --%>
<%@ include file="test6.jsp" %>
</body>
</html>