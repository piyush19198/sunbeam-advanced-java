<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEW DEVICE</title>
</head>
<body>
	<form action="/addmobile" method = "post">
		<table>
			<tr>
				<td>ID</td>
				<td>COMPANYNAME</td>
				<td>MODEL</td>
				<td>PRICE</td>
			</tr>
			<tr>
				<td><input type = "text" value = "ENTER ID" name = "id"></td>
				<td><input type = "text" value = "ENTER COMPANY NAME" name = "companyname"></td>
				<td><input type = "text" value = "ENTER MODEL" name = "model"></td>
				<td><input type = "number" value = "ENTER PRICE" name = "price"></td>
			</tr>
		</table>
		<input type = "submit" value = "ADD DEVICE">
	</form>
</body>
</html>