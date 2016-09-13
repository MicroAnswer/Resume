<%@page import="com.Answer.Tools.Application"%>
<%@page import="com.Answer.Database.DataBaseManager"%>
<%@ page language="java" import="java.util.*,com.Answer.Bean.*"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="com.Answer.CustomSimpleTag" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	User u = null;
	u = (User) session.getAttribute("user");
	if (u == null || !u.getName().equals("范雪蛟")) {//不是我自己，让别人不能访问这个页面
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	} else {

		DataBaseManager manager = Application.getdatabaseManager(session);
		pageContext.setAttribute("allusers", manager.getAllUser());
%>

<!DOCTYPE>
<html>
<head>
<link rel="shortcut icon" href='<s:home/>/bg/fan.ico' />
<base href="<%=basePath%>">

<title>用户删除管理</title>

</head>

<body>
	<h2 style="text-align: center; width: 100%;">
		所有用户<span style="font-size: 12px; color: red;">${hint}</span>
	</h2>
	<hr>
	<table border="1" style="width: 100%; text-align: center;"
		cellspacing="0">
		<tr>
			<th><input type="checkbox" />全选</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>生日</th>
			<th>QQ</th>
			<th>手机</th>
			<th>住址</th>
			<th>email</th>
			<th>操作</th>
		</tr>
		<c:forEach var="uu" items="${allusers}">
			<tr>
				<td><input type="checkbox" /></td>
				<td>${uu.name}</td>
				<td>${uu.age}</td>
				<td><c:if test="${uu.sex == 1}">男</c:if>
					<c:if test="${uu.sex != 1}">女</c:if></td>
				<td>${uu.birthday}</td>
				<td>${uu.QQ}</td>
				<td>${uu.tel}</td>
				<td>${uu.addr}</td>
				<td>${uu.email}</td>
				<td><a href='<s:home/>/delete?id=${uu.id}'>删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<%
		}
	%>
</body>
</html>
