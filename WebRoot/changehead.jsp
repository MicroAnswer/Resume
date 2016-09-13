<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="com.Answer.CustomSimpleTag" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>
<link rel="shortcut icon" href='<s:home/>/bg/fan.ico' />
<base href="<%=basePath%>">

<title>修改我的头像</title>
<style type="text/css">

body {
	background: url(<s:home/>/bg/home_main_bg.png);
	background-attachment: fixed;
}

body div  *{
border-radius:5px;
font-family: microsoft yahei;
}</style>
</head>

<body>
<s:main bgColor="#ffffff" height="600">
<a href='<s:home/>/home.jsp'
			style="float:right; margin-top: -25px; color:#ffffff; margin-right: 20px;">返回主页</a>
<div style="width:300px; height:300px; margin: 25px auto 0px auto; text-align: center; font-size: 30px;">
当前头像：<br/><br/>
	<img alt="#" src='<s:home/>${user.head}' style="width: 200px; height:200px; border: #000000 1px solid;">
	</div>
	<hr>
	<div style="width:400px; height:300px; margin: 25px auto 0px auto; text-align: center; font-size: 30px;">上传你的新头像<br/><br/>
		<form action='<s:home/>/changehead' method="post" enctype="multipart/form-data">
			<input name="head"  type="file"  style="border: 2px #000000 solid; margin-right: 20px;"  /><input value="上传" type="submit"/>
		</form>
		<br/>
		<span Style="color:red">${hint }</span>
		
	</div>
</s:main>


</body>
</html>
