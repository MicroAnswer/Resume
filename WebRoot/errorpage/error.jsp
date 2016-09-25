<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="com.Answer.CustomSimpleTag" prefix="s"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	Enumeration<String> names = request.getAttributeNames();
	String mexception = new String();
	int code = -1;
	while (names.hasMoreElements()) {
		String name = names.nextElement();
		if (name.contains("status_code")) {
			code = Integer.parseInt("" + request.getAttribute(name));
		} else
			mexception += name + "：" + request.getAttribute(name)
					+ "<br/>";

	}
%>
<title>出现错误</title>
</head>
<body>
	<a href='<s:home/>/home.jsp'
		style="width: 100px; height: 40px; display: block; background-color: #ffffff; margin: 0px auto 0px auto; line-height: 40px; text-align: center; border-radius: 5px; text-decoration: none; border: 1px #000000 solid;">回到主页</a>
	<div
		style="margin: 12px auto 0px auto; padding: 0px; width: 696px; height: 600px; border: 2px solid #000000; border-radius: 15px; background: rgba(255, 255, 255, 0.55); color: #000000;">
		<p
			style="margin: -1px; width: 680px; padding-left: 15px; border: 2px solid #000000; line-height: 60px; background: #000000; font-size: 30px; border-radius: 15px 15px 0px 0px; color: #ffffff; font-family: microsoft yahei;">
			出现错误—<%=code%>(<%
					switch(code){
					case 400 :out.write("无法解析此请求");break;
					case 403:out.write("禁止访问：访问被拒绝");break;
					case 404 :out.write("找不到文件或目录");break;
					case 405:out.write("用于访问该页的 HTTP 动作未被许可");break;
					case 406 :out.write("客户端浏览器不接受所请求页面的 MIME 类型");break;
					case 407:out.write("Web 服务器需要初始的代理验证");break;
					case 410 :out.write("文件已删除");break;
					case 412:out.write("客户端设置的前提条件在 Web 服务器上评估时失败");break;
					case 414 :out.write("请求 URL 太大，因此在 Web 服务器上不接受该 URL");break;
					case 500:out.write("服务器内部错误");break;
					case 501 :out.write("标题值指定的配置没有执行");break;
					case 502:out.write("Web 服务器作为网关或代理服务器时收到无效的响应");break;
					default:out.write("服务器还没准备好，请稍后再试");break;
					}
					%>)
		</p>
		<p
			style="padding-left: 15px; padding-right: 15px; width: 650px; height: 600px;"><%=mexception%></p>
	</div>
</body>
<script type="text/javascript" src='<s:home/>/js/index.js'></script>
</html>