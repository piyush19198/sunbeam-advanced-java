<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD JSP</title>
</head>
<body>
	<h5>Enter Vendor Details</h5>
	<form action="/add" method = "post">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="cellNo"></td>
			</tr>
			<tr>
				<td>regAmount</td>
				<td><input type="text" name="regAmount"></td>
			</tr>
			<tr>
				<td>regDate</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<td>role</td>
				<td><input type="text" name="role"></td>
			</tr>
		</table>
		<input type="submit" value="ADD">
	</form>
</body>
</html>