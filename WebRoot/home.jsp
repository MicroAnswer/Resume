<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>主页--欢迎</title>

<style type="text/css">
body {
	background: url(<s:home/>/bg/home_main_bg.png);
	background-attachment: fixed;
}

body * {
	margin: 0px;
	padding: 0px;
	font-family: microsoft yahei;
	border-radius: 5px;
}

.tdd {
	padding: 10px;
	padding-left: 50px;
	padding-right: 50px;
	line-height: 30px;
}

.login-hint {
	height: 30px;
	line-height: 30px;
	color: #ffffff;
	float: right;
	font-size: 14px;
	padding-right: 6px;
}

.login-hint a {
	margin-left: 6px;
	color: #ffffff;
	text-decoration: none;
	color: #ffffff;
}

img {
	border-radius: 5px;
}

.login-hint a:HOVER {
	color: #FFFF33;
	text-decoration: underline;
}

.lookR {
	float: right;
	height: 350px;
	width: 800px;
	border-radius: 0px;
	display: block;
	margin-top: 0px;
	cursor: pointer;
}

.lookRb {
	float: right;
	height: 350px;
	width: 800px;
	border-radius: 0px;
	display: block;
	margin-top: 0px;
	cursor: pointer;
}

.lookR:HOVER {
	display: block;
	background: rgba(100, 200, 0, 1);
}

.lookl {
	float: right;
	height: 266px;
	width: 800px;
	border-radius: 0px 0px 14px 14px;
	display: block;
	margin-top: 0px;
	cursor: pointer;
}

.lookl:HOVER {
	display: block;
	background: #ff5500;
}

.appcenter {
	float: left;
	height: 350px;
	display: block;
	border-radius: 0px;
	width: 398px;
}

.chart {
	float: left;
	height: 350px;
	display: block;
	border-radius: 0px;
	width: 399px;
}

.appcenter:HOVER {
	background: #884898;
}

.chart:HOVER {
	background: #f79ab5;
}
</style>
</head>

<body>
	<div
		style="width: 800px; height: 1000px; border-radius: 15px; border: #000000 2px solid; background-color: rgba(229, 222, 193, 1); margin: 12px auto 0px auto;">
		<div
			style="height: 30px; width: 100%; background: #123456; border-radius: 15px 15px 0px 0px; margin: -1px; border: 1px #123456 solid;">
			<img alt="#" src="bg/logo_answer.png" style="margin-left: 24px;">

			<span class="login-hint">你好<c:choose>
					<c:when test="${user == null }">
						<s:Ip />
						<a href='<s:home/>/login.jsp'>登录</a>
						<a href="<s:home/>/reg.jsp">注册</a>
					</c:when>
					<c:when test="${user != null }">
						<a href='<s:home/>/me.jsp'>${user.name}</a>
						<a href='<s:home/>/logout'>[注销]</a>
					</c:when>
				</c:choose>
			</span>
		</div>
		<div class="lookR" onclick="window.location.href=('<s:home/>/he.jsp')">
			<p style="margin-top: 30px;"></p>
			<p style="margin-left: 40px; font-size: 60px;">个人简历</p>
			<p style="margin-left: 50px; font-size: 33px; margin-top: 12px;">范雪蛟</p>
			<p style="margin-left: 50px; margin-top: 12px; line-height: 30px;">
				电话：13541227014<br /> 地址：四川省成都市郫县<br /> 毕业院校：四川托普信息技术职业学院<br />
				就读专业：移动软件开发<br /> E- mail：microanswer@outlook.com
			</p>
			<img src='<s:home/>/bg/f.jpg' width="201" height="280"
				style="float: right; margin-right: 40px; margin-top: -280px; display: none; border: 1px solid #000000;" />
			<br />
		</div>
		<hr
			style="height: 1px; background-color: #000; border: 1px #000000 solid;" />
		<div class="lookRb">

			<div class="appcenter"
				onclick="window.location.href=('<s:home/>/appcenter.jsp')">
				<!-- <p style="margin-top: 30px;"></p> -->
				<p style="margin-left: 40px; margin-top: 30px; font-size: 60px;">软件下载</p>
				<p style="margin-left: 50px; font-size: 33px; margin-top: 12px;">开发编程</p>
				<p style="margin-left: 50px; margin-top: 12px; line-height: 30px;">
					My eclipse 2014<br /> PhotoShop CS6<br /> Eclipse ADT+SDK<br />
					JDK 8<br />等等...
				</p>
				<br />
			</div>
			<div class="centerline"
				style="width: 3px; height: 350px; background-color: #000; float: left; display: block;"></div>

			<div class="chart"
				onclick="window.location.href=('<s:home/>/chart.html')">
				<p style="margin-left: 40px; margin-top: 30px; font-size: 60px;">聊天</p>
				<p style="margin-left: 50px; font-size: 33px; margin-top: 12px;">和所有在线的用户聊天</p>
				<p style="margin-left: 50px; margin-top: 12px; line-height: 30px;">
					也许，你还会遇到一个不错的朋友<br /> 祝你好运<br />
				</p>
				<br /> <img style="margin-left: 50px;" alt="桃心" width="70"
					height="70" src='<s:home/>/bg/taoxing.png' />
			</div>



		</div>
		<hr
			style="height: 1px; background-color: #000; border: 1px #000000 solid;" />
		<div class="lookl"
			onclick="window.location.href=('<s:home/>/talk?pagenumber=1')">
			<p style="margin-top: 30px;"></p>
			<p style="margin-left: 40px; font-size: 60px;">留言板</p>
			<p style="margin-left: 50px; font-size: 33px; margin-top: 12px;">对他的印象和对本站的看法</p>
			<p style="margin-left: 50px; margin-top: 12px; line-height: 30px;">
				勇敢表达，他都会虚心接受的</p>
			<br />
		</div>



	</div>
	<div
		style="width: 800px; height: 90px; background-color: #000000; margin: 10px auto 0px auto; text-align: center; color: #ffffff; padding-top: 10px;">
		制作： 范雪蛟<br />Answer QQ:374288225<br />电话：13541227014 <br />
		<s:showTime />
	</div>

</body>
</html>
