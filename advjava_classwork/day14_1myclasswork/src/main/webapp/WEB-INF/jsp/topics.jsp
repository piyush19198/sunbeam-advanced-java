<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Topics</title>
</head>
<body>
	Hello, ${uname} <hr/>
	
	<h2>Topics</h2>
	
	<sf:form method="post" action="topictutorials">
		<sf:radiobuttons path="topic" items="${topicList}" itemValue="id" itemLabel="name" delimiter="<br/>" />
			<%-- <input type="radio" name="topic" value="t.id"> <label>t.name</label> --%>
		<br/><br/>
		<input type="submit" value="Submit"/>
	</sf:form>
</body>
</html>


