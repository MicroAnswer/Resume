<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="com.Answer.CustomSimpleTag" prefix="s"  %>
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

<title>新用户注册</title>
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
width: 100px; height:40px; display: block; text-decoration: none;
background: #55ff55;
border:solid #113355 1px;
text-align: center;
line-height: 40px;
color:black;
margin: 230px auto 0px auto;
}
a:HOVER {
	background: #ee5555;
}
</style>
<script type="text/javascript">
	function changeimg(img){
		img.src = "<s:home/>/checkimg?time= "+new Date().getTime();
	}
</script>
</head>

<body>
	<s:main bgColor="rgba(255,255,255,0.6)" height="700">
		<s:main width="350" height="580" bgColor="#ffffff" topbg="#552288" borderColor="#552288" margin="50px 0px 0px 25px">
			<form action='<s:home/>/regservlet' style="margin: 40px 0px 0px 40px" method="post">
				用户名：<input type="text" name="Name" style="margin-top: 5px;height:30px;width:200px;" value="${Name}"/><br/>
				密　码：<input type="password" name="Password" style="margin-top: 20px;height:30px;width:200px;"/><br/>
				性　别：<input type="radio" name="sex" style="margin-top: 20px; margin-left: 40px;" checked="checked" value="1"/>男<input style="margin-left: 40px;" type="radio" name="sex" value="0"/>女<br/>
				邮　箱：<input type="text" name="email" style="margin-top: 20px;height:30px;width:200px;" value="${email}"/><br/>
				Q　 Q  ：<input type="number" name="QQ" style="margin-top: 20px;height:30px;width:200px;"value="${QQ}"/><br/>
				手　机：<input type="tel" name="Tel" style="margin-top: 20px;height:30px;width:200px;" value="${Tel}"/><br/>
				生　日：<input type="date" name="birthday" style="margin-top: 20px;height:30px;width:200px;" value="${birthday}"/><br/>
				地　址：<input type="text" name="addr" style="margin-top: 20px;height:30px;width:200px;" value="${param.addr}"/><br/>
				验证码：<input type="text" name="checkNum" style="margin-top: 20px;height:30px;width:70px;" maxlength="4"/><img src='<s:home/>/checkimg' style=" float:right;margin: 20px 46px 0px 0px;cursor: pointer;" onclick="changeimg(this)"/><br/>
				<input type="submit" value="注册" style="width:100px; height:40px; margin: 30px 0px 0px 90px;"/>
			</form>
		</s:main>
		<s:main width="350" height="580" bgColor="#ffffff" topbg="#552288" borderColor="#552288" margin="-585px 25px 0px 0px" mCustomStyle="float:right;">
			<div style="margin:30px; width: 300px ; height:50px; font-size: 30px; color:#159357;">当前已经有<s:AllUsersCount/>个用户注册了本站</div>
			<div style="margin:30px; width: 300px ; height:50px; font-size: 30px; color:#853491;">温馨提示：请牢记密码！</div>
				<div style="margin-top:50px; width: 100% ; height:50px; font-size: 30px; color:#ff0000; text-align: center;">${hint}</div>
				<a class="backhome" href='<s:home/>/home.jsp'>回到主页</a>
		</s:main>
	</s:main>
	<div
		style="width: 800px; height: 90px; background-color: #000000; margin: 10px auto 0px auto; text-align: center; color: #ffffff; padding-top: 10px;">
		制作： 范雪蛟<br />Answer QQ:374288225<br />电话：18784320961 <br />
		<s:showTime />
	</div>
</body>
</html>
