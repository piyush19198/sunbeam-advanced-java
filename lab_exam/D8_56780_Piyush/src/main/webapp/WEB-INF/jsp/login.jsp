<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
	<form action="/authenticate" method = "post">
		<h3>LOGIN HERE</h3>
		<br>
		<h1>Enter email: </h1>
		<input name = "email" type = "email" value = "guest@gmail.com">
		<br>
		<h1>Enter password: </h1>
		<input name = "password" type = "password">
		<br>
		<input type = "submit" value = "SIGN IN">
		<a href = "/adduser">SIGN UP HERE</a>
	</form>
</body>
</html>