<%@page import="com.sunbeam.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validate</title>
</head>
<body>
	<%--
		UserBean ub = new UserBean();
		ub.setEmail(request.getParameter("email"));
		ub.setPassword(request.getParameter("password"));
		ub.validateUser();
		if(ub.getUser() == null) {
			// Login Failed
		} else if(ub.getUser().getRole().equals("admin")) {
			// Go to Admin page (manage.jsp)
		} else {
			// Go to Customer page (topics.jsp)
		}
	--%>

	<jsp:useBean id="ub" class="com.sunbeam.beans.UserBean"/>	
	<%--
	<jsp:setProperty name="ub" property="email" param="email"/>
	<jsp:setProperty name="ub" property="password" param="password"/>
	--%>
	<jsp:setProperty name="ub" property="*"/>
	
	${ub.validateUser()}
	<c:choose>
		<c:when test="${empty ub.user}">
			Invalid email or password. <br/>
			<a href="login.jsp">Login Again</a>
		</c:when>
		<c:when test="${ub.user.role == 'admin'}">
			<jsp:forward page="manage.jsp"/>
		</c:when>
		<c:otherwise>
			<c:redirect url="topics.jsp"/>
		</c:otherwise>	
	</c:choose>
</body>
</html>





