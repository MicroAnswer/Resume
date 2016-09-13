<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="com.Answer.CustomSimpleTag" prefix="s"%>
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
<script type="text/javascript">
	function changeimg(img){
		img.src = "<s:home/>/checkimg?time= "+new Date().getTime();
	}
</script>
<style type="text/css">
body{
background: url(<s:home/>/bg/home_main_bg.png); 
background-attachment: fixed;
}
body *{
	border-radius:5px;
	font-family: microsoft yahei;
}
	a{
	margin:80px auto 0px auto;
		display: block;
		width:100px;
		height:45px;
		background: #fff666;
		border-radius:10px;
		border: #666fff 2px solid;
		text-align: center;
		line-height: 45px;
		text-decoration: none;
	}
	a:HOVER {
		background: #ffaa66;
		color: #000000;
		
}
.submit{
background:#55ff55;
border:2px #66ee66 solid;
cursor: pointer;}
.submit:HOVER {
	background: #119911;
	border:2px #118811 solid;
}


.backhome{
width: 200px;
height:40px; 
display: block;
text-decoration: none;
background: #55ff55;
border:solid #113355 1px;
text-align: center;
line-height: 40px;
color:black;
margin: 100px auto 0px auto;
}
.backhome:HOVER {
	background: #ee5555;
}
</style>
<title>登录</title>


</head>

<body >
	<s:main radius="15" height="700" bgColor="rgba(255,255,255,0.7)" borderColor="#123456">
		<s:main width="330" height="300" margin="100px 0px 0px 30px" 
			radius="10" bgColor="rgba(255,255,255,0.2)" topbg="#552288" borderColor="#552288">
			<form action="<s:home/>/loginservlet" style="margin: 32px 0px 0px 32px;" method="post">
				用户名：<input name="Name" type="text" style="margin-top: 5px; height:30px;width:200px;"/><br/>
				密　码：<input name = "Password" type="password" style="margin-top: 20px;height:30px;width:200px;"/><br/>
				验证码：<input name="checkNum" type="text" style="margin-top: 20px;height:30px; width:60px;" maxlength="4"/>
				<img src='<s:home/>/checkimg' style="margin: 20px 34px 0px 0px;height:30px; float:right; cursor: pointer; border: 1px solid #000000;" onclick="changeimg(this)" /><br/>
				<input type="submit" value="登录" style="margin:30px 0px 0px 90px;height:40px;width:100px;" class="submit"/>
			</form>
		</s:main>
		<s:main width="330" height="301" bgColor="rgba(255,255,255,0.2)" topbg="#552288" borderColor="#552288" radius="10" margin="-305px 30px 0px 0px" mCustomStyle="float:right;" >
		<p style="font-size:25px; color:#993366; margin:20px; ">还咩有账号？火速注册一个吧！</p>
			<a href='<s:home/>/reg.jsp'>我要注册</a>
		</s:main>
<a class="backhome" href='<s:home/>/home.jsp'>回到主页</a>
	</s:main>
</body>
</html>
