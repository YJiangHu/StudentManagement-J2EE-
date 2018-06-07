<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<jsp:include page="/head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.col-center-block {
	float: none;
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
	<br>
	<div class="col-xs-8 col-md-10 col-center-block">
		<c:if test="${empty student}">
			<h3 style="color: #ac2925" align="center">没有此学生</h3>
			<p align="center">
			<button type="button" class="btn btn btn-success"
				onclick="window.location.href='${path}/list'">
				<span class="glyphicon glyphicon-chevron-left">返回列表</span> <span>-</span>
			</button>
			</p>
		</c:if>
		<c:if test="${!empty student}">
			<h2 align="center">查询结果</h2>
			<br>
			<br>
			<button type="button" class="btn btn btn-success"
				onclick="window.location.href='${path}/list'">
				<span class="glyphicon glyphicon-chevron-left">返回列表</span> <span>-</span>
			</button>
			<table
				class="table table-striped table table-hover table table-bordered">
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>班级</th>
					<th>电话</th>
					<th>操作</th>
				</tr>
				<tr>
					<td>${student.id }</td>
					<td>${student.name }</td>
					<td>${student.sex }</td>
					<td>${student.clazz }</td>
					<td>${student.phone }</td>
					<td><button type="button" class="btn btn-danger"
							onclick="window.location.href='${path}/delete?id=${student.id}'">删除</button>
						<button type="button" class="btn btn-info"
							onclick="window.location.href='${path}/updateForm?id=${student.id}'">编辑</button>
					</td>
				</tr>
			</table>
		</c:if>
	</div>
</body>
</html>