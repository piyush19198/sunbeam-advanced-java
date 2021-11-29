<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Online Tutorials</h2>
	<sf:form method="post" modelAttribute="command" action="validate">
		<table>
			<tr>	
				<td>Email:</td>
				<td><sf:input path="email"/></td>
			</tr>
			<tr>	
				<td>Password:</td>
				<td><sf:password path="password"/></td>
			</tr>
			<tr>	
				<td colspan="2">
					<input type="submit" value="Sign In"/>
					<a href="#">Sign Up</a>
				</td>
			</tr>
		</table>
	</sf:form>
</body>
</html>
