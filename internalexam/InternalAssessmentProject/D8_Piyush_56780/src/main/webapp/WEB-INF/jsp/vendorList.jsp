<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>VENDORLIST JSP</title>
</head>
<body>
	<h4>Vendor Details</h4>
	<h4>Hello ${vendor.name}</h4>
	<h4>Your Details are :</h4>
	<h4>Vendor ID: ${vendor.id}</h4>
	<h4>Vendor NAME: ${vendor.name}</h4>
	<h4>Vendor EMAIL: ${vendor.email}</h4>
	<h4>Vendor CITY: ${vendor.city}</h4>
	<h4>Vendor CELLNO: ${vendor.cellNo}</h4>
	<h4>Vendor REGAMOUNT: ${vendor.regAmount}</h4>
	<h4>Vendor REGDATE: ${vendor.date}</h4>
	<h4>Vendor ROLE: ${vendor.role}</h4>
	<a href="logout">LOGOUT</a>
	
	
</body>
</html>