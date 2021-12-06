<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE JSP</title>
</head>
<body>
	<h5>Update Vendor</h5>
	<form action="/update">
		<table style="margin: auto;">
			<tr>
				<td><input type="hidden" name="id" value="${vendor.id }"></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city" value="${vendor.city }"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="cellNo" value="${vendor.cellNo }"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>