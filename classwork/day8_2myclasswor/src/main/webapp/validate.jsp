<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="user" class="beans.UserBean" scope="session" />
<jsp:setProperty property="*" name="user" />

<body>

	<%-- <%
    user.validateUser();
%> --%>
	<%-- how to invoke JB's B.L method using EL syntax? --%>
	<%-- session.getAttribute("user").validateUser() --%>
	<%--response.sendRedirect(response.encodeRedirectURL(session.getAttribute("user").validateUser().concat(".jsp") --%>
	<c:redirect url="${sessionScope.user.validateUser()}.jsp" />
</body>
</html>