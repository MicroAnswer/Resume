<%@page import="com.Answer.Bean.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="com.Answer.CustomSimpleTag" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	User u = (User) session.getAttribute("user");
	if (u == null) {//没有登录，跳转到登陆界面
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	} else {
%>

<!DOCTYPE>
<html>
<head>
<link rel="shortcut icon" href='<s:home/>/bg/fan.ico' />
<base href="<%=basePath%>">
<style type="text/css">
body {
	background: url(<s:home/>/bg/home_main_bg.png);
	background-attachment: fixed;
}

body div * {
	border-radius: 5px;
	float: left;
	font-family: microsoft yahei;
	margin: 0px;
	padding: 0px;
}

.headDiv {
	margin: 30px;
	cursor: pointer;
	border: 1px solid #000000;
	width: 200px;
	height: 200px;
}

.headDiv a {
	border-radius: 0px 0px 5px 5px;
	float: left;
	width: 100%;
	height: 50px;
	display: block;
	margin-top: -50px;
	color: #ffffff;
	display: none;
	line-height: 50px;
	text-align: center;
	font-size: 20px;
	background-color: rgba(2, 2, 2, 0.5);
	text-align: center;
	line-height: 50px;
	text-align: center;
}
</style>
<title>${user.name }的个人主页</title>

</head>

<body>
	<s:main bgColor="#ffffff" height="700">
		<a href='<s:home/>/home.jsp'
			style="float: right; margin-top: -25px; color: #ffffff; margin-right: 20px;">返回主页</a>
		<div class="headDiv" id="headDiv">
			<img alt="" src='<s:home/>${user.head}' width="200" height="200"
				style="width: 200px; height: 200px;"> <a id="cha"
				href='<s:home/>/changehead.jsp'>修改头像</a>
		</div>
		<div style="width: 300px; height: 250px;">
			<p
				style="font-size: 50px; margin-top: 40px; color: #116633; float: none;">${user.name }</p>
			<p style="font-size: 30px; margin-top: 10px; float: none;">QQ:${user.QQ }</p>
			<p style="font-size: 30px; margin-top: 10px; float: none;">手机:${user.tel }</p>
		</div>
		<hr style="width: 100%;" />
		<a
			style="width: 100%; background-color: rgba(100, 100, 200, 0.6); border-radius: 0px; height: 30px; text-align: center; line-height: 30px; cursor: pointer;"
			href='<s:home/>/alterme.jsp'>修改我的信息</a>
		<h4 style="line-height: 40px; margin-top: 25px; margin-left: 40px;">
			生日：${user.birthday }<br />年龄：${user.age }<br />性别：
			<c:if test="${user.sex == 1}">男</c:if>
			<c:if test="${user.sex!=1 }">女</c:if>
			<br />地址：${user.addr}<br />Email:${user.email}<br />个人说明：${user.info}
			<br /> ${hint }
		</h4>
	</s:main>
</body>
<script type="text/javascript" src='<s:home/>/js/Base.js'></script>
<script type="text/javascript">
	window.onload = function() {
		tool().getId('headDiv').hover(function() {
			tool().getId('cha').show();
		}, function() {
			tool().getId('cha').hide();
		});
	};
</script>
</html>
<%
	}
%>