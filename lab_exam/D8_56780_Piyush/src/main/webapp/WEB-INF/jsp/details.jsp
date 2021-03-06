<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MOBILE DETAILS</title>
</head>
<body>
	<h2>MOBILE LIST</h2>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>COMPANYNAME</th>
				<th>MODEL</th>
				<th>PRICE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="m" items="${MobileList}">
				<tr>
					<td>${m.id}</td>
					<td>${m.companyname}</td>
					<td>${m.model}</td>
					<td>${m.price}</td>
					<td><a href="/edit?id=${m.id}">EDIT PRICE</a></td>
					<td><a href="/delete?id=${m.id}">DELETE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="/add">ADD NEW DEVICE</a>
	<a href="/logout">LOGOUT</a>
</body>
</html>