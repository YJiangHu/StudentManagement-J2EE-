<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<jsp:include page="${path }/head.jsp"></jsp:include>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>增加信息</title>
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
	<div class="col-xs-6 col-md-4 col-center-block">
	<h2>添加学生信息</h2>
	<br>
	<br>
    <form class="form-inline" action="${path}/insert" method="post">
        <div class="form-group">
            <label for="inputId">学号：</label>
            <input type="text" class="form-control" id="inputId" name="id" placeholder="请输入纯数字学号">
            <br>
            <br>
            <label for="inputName">姓名：</label>
            <input type="text" class="form-control" id="inputName" name="name">
            <br>
            <br>
            <label for="inputSex">性别：</label>
            <select class="form-control" name="sex" id="inputSex">
                <option>男</option>
                <option>女</option>
            </select>
            <br>
            <br>
            <label for="inputClass">班级：</label>
            <input type="text" class="form-control" id="inputClass" name="clazz">
            <br>
            <br>
            <label for="inputPhone">电话：</label>
            <input type="text" class="form-control" id="inputPhone" name="phone" placeholder="请输入纯数字电话">
            <br>
            <br>
            <p align="center">
	            <button type="submit" class="btn btn-success">提交</button>
	            <button type="button" class="btn btn-primary"
	            	 onclick="window.location.href='${path}/list'">取消</button>
            </p>
            <c:if test="${!empty idmsg }">
				<p style="color: red;">${idmsg }</p>
			</c:if>
			<c:if test="${!empty phonemsg }">
				<p style="color: red;">${phonemsg }</p>
			</c:if>
        </div>
    </form>
</div>
</body>
</html>