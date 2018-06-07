<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="head.jsp"></jsp:include>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%
		String root = (String)request.getAttribute("path");	
		response.sendRedirect("list");
	%>
</head>
<body>
	
</body>
</html>