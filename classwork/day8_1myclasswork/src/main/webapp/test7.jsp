<%@page import="pojos.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>In test7 page .....</h5>
	<%
	out.flush();
	//create product POJO n add it in a suitable scope : min scope : SP : request
	Product product1 = new Product(Integer.parseInt(request.getParameter("pid")),
			request.getParameter("name"),
			Double.parseDouble(request.getParameter("price")));
	request.setAttribute("product_dtls", product1);
	
	%>
	<%-- RD : include --%>
	<jsp:include page="test8.jsp"/>
	<h5>contents post include....</h5>
</body>
</html>