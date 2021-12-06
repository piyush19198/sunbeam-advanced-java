<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="/css/site.css">
</head>
<body>
	<h2><s:message code="app.title"/></h2>
	<img alt="Logo" src='<s:message code="logo.image"/>'>
	<sf:form method="post" modelAttribute="command" action="validate">
		<table>
			<tr>	
				<td><s:message code="email.label"/>:</td>
				<td><sf:input path="email"/></td>
				<td><sf:errors cssClass="error" path="email"/></td>
			</tr>
			<tr>	
				<td><s:message code="password.label"/>:</td>
				<td><sf:password path="password"/></td>
				<td><sf:errors cssClass="error" path="password"/></td>
			</tr>
			<tr>	
				<td colspan="3">
					<input type="submit" value=<s:message code="signin.label"/>/>
					<a href="#"><s:message code="signup.label"/></a>
				</td>
			</tr>
		</table>
	</sf:form>

	<%--
	Display all errors.	
	<sf:errors path="*"/>
	--%>
</body>
</html>

