<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
<link rel="shortcut icon" href='<s:home/>/bg/fan.ico' />
    <base href="<%=basePath%>">
    <style type="text/css">
    body *{
    font-family: microsoft yahei;
    }
    </style>
    <title>注册成功</title>
  </head>
  
  <body style="background-color: #446688">
   <div style="width: 380px; height:350px; font-size: 40px;border-radius:15px; border: 2px solid #00ff00;  background-color: #00ff00;color:#990000; text-align: center; margin: 200px auto 0px auto;">
   <p style="margin-top: 100px;">恭喜您注册成功</p>
   <p style="font-size: 30px;">正在为您自动登录到主页面</p>
   </div>
  </body>
</html>
