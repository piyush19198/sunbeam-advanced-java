<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dtlsb" class="com.sunbeam.beans.DetailsBean" />
	<jsp:setProperty name="dtlsb" property="tut_id" param="id"/>
	<h4>Id : ${dtlsb.fetchTutorialDetails().id}<br></h4>
	<h4>Name : ${dtlsb.fetchTutorialDetails().name}<br></h4>
	<h4>Author : ${dtlsb.fetchTutorialDetails().author}<br></h4>
	<h4>Content : ${dtlsb.fetchTutorialDetails().contents}<br></h4>
	<h4>Date : ${dtlsb.fetchTutorialDetails().publishDate}<br></h4>
	${dtlsb.updateVisits()}
	<h4>visits : ${dtlsb.fetchTutorialDetails().visits}<br></h4>
	
	<br/> <a href="topics.jsp">Back to Topics</a>
	<br>
	<br/> <a href="logout.jsp">LOGOUT</a>
	
</body>
</html>