<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="com.Answer.CustomSimpleTag" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>
<link rel="shortcut icon" href='<s:home/>/bg/fan.ico' />
<base href="<%=basePath%>">

<title>修改我的个人信息</title>
<style type="text/css">
body {
	background: url(<s:home/>/bg/home_main_bg.png);
	background-attachment: fixed;
}

body div * {
	border-radius: 5px;
	font-family: microsoft yahei;
	margin: 0px;
	padding: 0px;
}

.headDiv {
	margin-left: 100px;
	cursor: pointer;
	border: 1px solid #000000;
	width: 200px;
	height: 200px;
}

#cha {
	border-radius: 0px 0px 5px 5px;
	width: 100%;
	height: 50px;
	margin-top: -50px;
	color: #000000;
	display: none;
	line-height: 50px;
	font-size: 20px;
	background-color: #223344;;
	text-align: center;
	z-index: 9999;
}
</style>
</head>

<body>
	<s:main bgColor="#ffffff" height="540">
		<a href='<s:home/>/home.jsp'
			style="float: right; margin-top: -25px; color: #ffffff; margin-right: 20px;">返回主页</a>
		<form action='<s:home/>/alterinfo'
			style="margin: 40px 0px 0px 40px; float: left" method="post">
			用户名：<input type="text" readonly="readonly" name="Name"
				style="margin-top: 5px; height: 30px; width: 200px;"
				value="${user.name}(不可修改)" /><br /> 邮 箱：<input type="text"
				name="email" style="margin-top: 20px; height: 30px; width: 200px;"
				value="${user.email}" /><br /> Q Q ：<input type="number" name="QQ"
				style="margin-top: 20px; height: 30px; width: 200px;"
				value="${user.QQ}" /><br /> 手 机：<input type="tel" name="tel"
				style="margin-top: 20px; height: 30px; width: 200px;"
				value="${user.tel}" /><br /> 生 日：<input type="date"
				name="birthday"
				style="margin-top: 20px; height: 30px; width: 200px;"
				value="${user.birthday}" /><br /> 地 址：<input type="text"
				name="addr" style="margin-top: 20px; height: 30px; width: 200px;"
				value="${user.addr}" /><br /> 个人说明：<input type="text" name="info"
				style="margin-top: 20px; height: 30px; width: 200px;"
				value="${user.info}" /><br /> <input type="submit" value="修　改"
				style="width: 100px; height: 40px; margin: 30px 0px 0px 90px;" /> <a>${hint}</a>
		</form>
		<div
			style="float: left; width: 400px; height: 450px; border-left: 2px solid #000000; border-radius: 0px; margin: 0px 0px 0px 50px; padding-top: 60px;">
			<div class="headDiv" id="headDiv">
				<img alt="" src='<s:home/>${user.head}' width="200" height="200"
					style="width: 200px; height: 200px;"> <a id="cha"
					href="<s:home/>/changehead.jsp">修改头像</a>
			</div>
			<p
				style="margin: 70px auto 0px auto; font-size: 60px; width: 100%; text-align: center;">${user.name }</p>
		</div>
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
