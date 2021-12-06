<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>From 1st page...</h5>
	<%
	out.flush();
	//add 4 attributes under varying scopes (page | request | session | application)
	pageContext.setAttribute("nm1", 1234);
	request.setAttribute("nm2", 3456);
	session.setAttribute("nm3", 5678);
	application.setAttribute("nm4", 6789);
	%>
	<%--Use client Pull II : redirect --%>
	<!-- <h5>
		<a href="next.jsp">Next</a>
	</h5> -->
	<%
	//	response.sendRedirect("next.jsp");
	//RD : forward 
	RequestDispatcher rd = request.getRequestDispatcher("next.jsp");
	rd.include(request, response);
	%>
</body>
</html>