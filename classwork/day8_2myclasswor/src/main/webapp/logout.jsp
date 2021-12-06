<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>in logout page : Hello , ${sessionScope.user.userDetails.name}
	</h5>
	<%-- invalidate HttpSession --%>
	${pageContext.session.invalidate()}
	<h5>You have logged out n will be auto taken to login page....</h5>
	<!-- <h5>
		<a href="login.jsp">Visit Again</a>
	</h5> -->
	<%-- can be replace by similar code in Spring request handling Controller --%>	
	<%
	 //how to navigate the clnt to the next page : after some delay ?
			 //how : set HTTP resp header name n value
			 response.setHeader("refresh","5;url="+request.getContextPath());
			 
	%>

</body>
</html>