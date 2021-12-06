<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>From test1  page : Session ID : ${pageContext.session.id}</h5>
	<%
	//create session scoped attribute to store user details
	session.setAttribute("user_dtls", request.getParameter("name") + ":" + request.getParameter("pass"));
	//redirect the clnt ot next page in the next request
	//URL rewriting : Method of HttpServletResponse : public void encodeRedirectURL(String url)
	response.sendRedirect(response.encodeRedirectURL("test2.jsp"));
	%>

</body>
</html>