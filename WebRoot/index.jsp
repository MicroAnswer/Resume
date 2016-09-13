<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="com.Answer.CustomSimpleTag" prefix="s" %>
<!DOCTYPE>
<html>
<head>
<link rel="shortcut icon" href='<s:home/>/bg/fan.ico' /> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页--欢迎</title>
<style type="text/css">
body * {
	margin: 0px;
	padding: 0px;
	border-radius:5px;
}
a{
float:right; width: 150px; height:50px; display:block; line-height:50px; margin-top: 50px; text-align:center; font-size: 20px;font-family: microsoft yahei; background: #000000; color:#ffffff; border:2px #000000 solid; cursor: pointer;  border-radius:15px 0 0 15px;  
	text-decoration: none;
}
a:HOVER {
	background: #555555;
	border: #555555 2px solid;
}
a:ACTIVE {
	background: #000000;
	border: #000000 2px solid;
}
</style>

</head>
<body bgcolor="#aaaaff">
	<div
		style="margin: 24px auto 24px auto; width: 800px; height: 1000px; border: 1.5px solid #000; background: url('bg/main_bg.png') #000000;">
		<p
			style="height: 20px; font-size: 15px; color: #aaaaaa; line-height: 20px; text-align: center; padding: 5px;">四川托普信息技术职业学院</p>
		<hr>
		<span style="font-size:10px; color:#aaaaaa; float:right;"><s:Ip/></span>
		<p
			style="font-size: 80px; margin-top: 90px; margin-left: 30px; font-family: microsoft yahei;">个人简历</p>
			
			<a href='<s:home/>/home.jsp'>开始阅读</a>
			
		<p style="color: #ffffff; margin-top: 500px; margin-left: 340px;font-family: microsoft yahei; line-height: 24px;">
			姓　　名：范雪蛟<br /> 专　　业：移动软件开发<br /> 毕业院校：四川托普信息技术职业学院<br />
			联系方式：13541227014<br /> E - mail ：www.fanxuejiao@outlook.com
		</p>

	</div>
</body>
	<script type="text/javascript" src='<s:home/>/js/index.js'></script>
</html>