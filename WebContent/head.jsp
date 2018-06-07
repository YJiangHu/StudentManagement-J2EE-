<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<!-- 定义项目根路径 -->
	<%
		String path = request.getContextPath();
		request.setAttribute("path", path);
	%>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="${path}/static/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${path}/static/js/bootstrap.min.js"></script>
</head>
<body>
	
</body>
</html>