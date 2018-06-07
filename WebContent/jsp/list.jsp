<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<jsp:include page="${path}/head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
	<h2 align="center">学生信息</h2>
	<br>
	<br>
	<div class="col-xs-8 col-md-10 col-center-block">
		<c:if test="${!empty msg }">
		<p style="color: red;">${msg }</p>
		</c:if>
		<form class="form-inline" action="${path}/getStudent?id=${id}"
			method="get">
			<div class="form-group">
				<label for="queryid">学号：</label> <input type="text"
					class="form-control" id="queryid" name="id" placeholder="请输入纯数字学号">
			</div>
			<button type="submit" class="btn btn-default">查询</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-success"
				onclick="window.location.href='${path}/jsp/insertForm.jsp'">添加</button>
		</form>
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
			<c:forEach items="${pageInfo.list}" var="student"
				begin="${pageInfo.begin}" end="${pageInfo.end }">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.sex}</td>
					<td>${student.clazz}</td>
					<td>${student.phone}</td>
					<td><button type="button" class="btn btn-danger"
							onclick="window.location.href='${path}/delete?id=${student.id}'">删除</button>
						<button type="button" class="btn btn-info"
							onclick="window.location.href='${path}/updateForm?id=${student.id}'">编辑</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="row">
		<p align="center">当前第 ${pageInfo.page } 页， 总 ${pageInfo.total } 页,
			共 ${pageInfo.size } 条记录</p>
		<!-- 分页条信息 -->
		<div class="col-md-6" align="right">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="${path}/list?page=1">首页</a></li>
					<c:if test="${pageInfo.hasPrevious() }">
						<li><a href="${path}/list?page=${pageInfo.page-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>

					<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
						<c:if test="${page_Num==pageInfo.page }">
							<li class="active"><a href="#">${page_Num }</a></li>
						</c:if>
						<c:if test="${page_Num!=pageInfo.page }">
							<li><a href="${path}/list?page=${page_Num }">${page_Num }</a></li>
						</c:if>
					</c:forEach>

					<c:if test="${pageInfo.hasNext() }">
						<li><a href="${path}/list?page=${pageInfo.page+1 }"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a href="${path}/list?page=${pageInfo.total}">末页</a></li>
				</ul>
			</nav>
		</div>
	</div>
</body>
</html>