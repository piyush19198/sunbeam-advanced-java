<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN JSP</title>
</head>
<body>

	<table style="margin: auto; color: red;">
		<tr>
			<td>ID</td>
			<td>NAME</td>
			<td>EMAIL</td>
			<td>CITY</td>
			<td>CELLNO</td>
			<td>REGAMOUNT</td>
			<td>REGDATE</td>
			<td>ROLE</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach var="vendor" items="${allVendors}">
			<tr>
				<form>
					<input type="hidden" value="${vendor.id}" name="id">
					<td>${vendor.id}</td>
					<td>${vendor.name}</td>
					<td>${vendor.email}</td>
					<td>${vendor.city}</td>
					<td>${vendor.cellNo}</td>
					<td>${vendor.regAmount}</td>
					<td>${vendor.date}</td>
					<td>${vendor.role}</td>
					<td><input type="submit" value="Update"
						formaction="/updateVendor"></td>
					<td><input type="submit" value="Delete"
						formaction="/deleteVendor"></td>
				</form>
			</tr>
		</c:forEach>
	</table>

	<h4 align="center">
		<a href="addVendor">Add New Vendor</a>
	</h4>
</body>
</html>