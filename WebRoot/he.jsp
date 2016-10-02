<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="com.Answer.CustomSimpleTag" prefix="s"%>
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
</style>
</head>

<body style="background: #eeffff">
	<div
		style="width: 800px; height: 2550px; border-radius: 15px; border: #000000 2px solid; background: #ffffff; margin: 12px auto 0px auto;">
		<div
			style="height: 30px; width: 100%; background: #123456; border-radius: 15px 15px 0px 0px; margin: -1px; border: 1px #123456 solid;">
			<img alt="#" src="bg/logo_answer.png" style="margin-left: 24px;">

			<span class="login-hint">你好<c:choose>
					<c:when test="${user == null }">
						<s:Ip />
						<a href='<s:home/>/login.jsp'>登录</a>
						<a href="<s:home/>/reg.jsp">注册</a>
					</c:when>
					<c:when test="${user != null }">${user.name}<a
							href='<s:home/>/logout'>[注销]</a>
					</c:when>
				</c:choose> <a href='<s:home/>/home.jsp'>返回主页</a>
			</span>
		</div>
		<p style="margin-top: 30px;"></p>
		<p style="margin-left: 40px; font-size: 60px;">个人简历</p>
		<p style="margin-left: 50px; font-size: 33px; margin-top: 12px;">范雪蛟</p>
		<p style="margin-left: 50px; margin-top: 12px; line-height: 30px;">
			电话：13541227014<br /> 地址：四川省成都市郫县<br /> 毕业院校：四川托普信息技术职业学院<br />
			就读专业：移动软件开发<br /> E- mail：microanswer@outlook.com
		</p>
		<img src='<s:home/>/bg/f.jpg' width="201" height="280"
			style="float: right; margin-right: 40px; margin-top: -280px; border: 1px solid #000000;" />
		<br />
		<hr />
		<br />
		<table cellspacing="0" width="720" align="center" border="1"
			style="margin: 0px auto 0px auto; border-radius: 5px; border: 1px #000000 solid;">
			<tr>
				<td width="97" rowspan="8" align="center">个人信息</td>
				<td colspan="4" align="left" class="tdd">姓名：范雪蛟 性别：男</td>
			</tr>
			<tr>
				<td colspan="4" align="left" class="tdd">民族：汉族 政治面貌：团员</td>
			</tr>
			<tr>
				<td colspan="4" align="left" class="tdd">年龄：23岁 出生日期：1992-10-10</td>
			</tr>
			<tr>
				<td colspan="4" align="left" class="tdd">身高：173厘米 学历：大专</td>
			</tr>
			<tr>
				<td colspan="4" align="left" class="tdd">籍贯：四川成都 健康状况：健康</td>
			</tr>
			<tr>
				<td colspan="4" align="left" class="tdd">毕业院校：四川托普信息技术职业学院</td>
			</tr>
			<tr>
				<td colspan="4" align="left" class="tdd">专业：移动软件开发</td>
			</tr>
			<tr>
				<td colspan="4" align="left" class="tdd">系别：计算机系</td>
			</tr>
			<tr>
				<td rowspan="3" align="center">主修课程</td>
				<td width="200" align="center"
					style="padding-top: 20px; padding-bottom: 20px; font-size: 25px;">
					<img src='<s:home/>/bg/C.png' width="100" height="135" border="1"
					style="margin-bottom: 10px;" /><br /> C语言程序设计
				</td>
				<td width="200" align="center"
					style="padding-top: 20px; padding-bottom: 20px; font-size: 25px;">
					<img src='<s:home/>/bg/java.jpg' width="100" height="135"
					border="1" style="margin-bottom: 10px;" /><br />Java程序设计
				</td>
				<td align="center" width="200" align="center"
					style="padding-top: 20px; padding-bottom: 20px; font-size: 20px;">
					<img src='<s:home/>/bg/android.jpg' width="100" height="135"
					border="1" style="margin-bottom: 10px;" /><br />Android手机软件开发
				</td>
			<tr>
				<td align="center" align="center"
					style="padding-top: 20px; padding-bottom: 20px; font-size: 25px;">
					<img src='<s:home/>/bg/datamake.jpg' width="100" height="135"
					border="1" style="margin-bottom: 10px;" /><br />数据结构
				</td>
				<td align="center" align="center"
					style="padding-top: 20px; padding-bottom: 20px; font-size: 25px;">
					<img src='<s:home/>/bg/javascript.png' width="100" height="135"
					border="1" style="margin-bottom: 10px;" /><br />JavaScript
				</td>
				<td align="center" align="center"
					style="padding-top: 20px; padding-bottom: 20px; font-size: 25px;">
					<img src='<s:home/>/bg/html.jpg' width="100" height="135"
					border="1" style="margin-bottom: 10px;" /><br />Html
				</td>
			<tr>
				<td align="center" align="center"
					style="padding-top: 20px; padding-bottom: 20px; font-size: 25px;">
					<img src='<s:home/>/bg/sql.jpg' width="100" height="135" border="1"
					style="margin-bottom: 10px;" /><br />SQL数据库
				</td>
				<td align="center" align="center"
					style="padding-top: 20px; padding-bottom: 20px; font-size: 25px;">
					<img src='<s:home/>/bg/Photoshop.jpg' width="100" height="135"
					border="1" style="margin-bottom: 10px;" /><br />PhotoShop
				</td>
				<td align="center" align="center"
					style="padding-top: 20px; padding-bottom: 20px; font-size: 25px;">
					<img src='<s:home/>/bg/apptest.png' width="100" height="135"
					border="1" style="margin-bottom: 10px;" /><br />软件测试
				</td>
			<tr>
				<td align="center">个人能力</td>
				<td colspan="1" class="tdd">大学英语三级</td>
				<td class="tdd">C1驾照</td>
				<td class="tdd">计算机二级</td>
			</tr>
			<tr>
				<td align="center">专业技能</td>
				<td colspan="4" class="tdd">
					在大学接受了全面的基础知识教育，熟练操作Office各版本办公软件，有优异的实践操作经验，在软件开发，Java编程，计算机原理等各个方面有扎实的功底，同时具备对未知事物较强的学习能力，能快速学会应用新技能。
				</td>
			</tr>
			<tr>
				<td rowspan="3" align="center">主要社会经历</td>
				<td colspan="4" class="tdd">2014年10月参加甲骨文Java编程大赛，明显提升了个人编程能力以及代码阅读能力。</td>
			</tr>
			<tr>
				<td colspan="4" class="tdd">2015年5月30日参加四川省计算机作品大赛，开启了游戏道路上一扇转折性的大门。</td>
			</tr>
			<tr>
				<td colspan="4" class="tdd">2015年6月13日参加全国职业技能大赛，提升了团队合作和编码速度。</td>
			</tr>
			<tr>
				<td rowspan="6" align="center">曾获奖励</td>
				<td colspan="4" class="tdd">2013年获得学院免学费资助</td>
			</tr>
			<tr>
				<td colspan="4" class="tdd">2014年被评为三好学生</td>
			</tr>
			<tr>
				<td colspan="4" class="tdd">2014年被评为优秀学生代表</td>
			</tr>
			<tr>
				<td colspan="4" class="tdd"><a
					 target="_blank" href="http://www.jingkao.net/cert/jingkaocertificates/view?certId=hJ8VgSpNcuSyOaJCA2J">2015年Java甲骨文编程大赛西南赛区一等奖</a></td>
			</tr>
			<tr>
				<td colspan="4" class="tdd">2015年四川省计算机作品大赛二等奖</td>
			</tr>
			<tr>
				<td colspan="4" class="tdd">2015年全国职业技能大赛三等奖</td>
			</tr>
			<tr>
				<td align="center">兴趣与特长</td>
				<td colspan="4" class="tdd"><p>阅读知识类书籍</p>
					<p>热爱电子产品，以及程序代码的编写，对计算机和手机方面了解非常详细，能独立组装电脑以及电脑手机等电子产品的维修和更新。</p></td>
			</tr>
			<tr>
				<td align="center">主要优点</td>
				<td colspan="4" class="tdd">对事情态度端正认真，一旦接到任务，就会尽全力执行并做到最好，有较强的语言表达能力，能清晰的表达自己的意见和想法，有责任心，面对事情镇定，不焦躁。</td>
			</tr>
			<tr>
				<td align="center">自我评价</td>
				<td colspan="4" class="tdd">本人工作认真，态度端正，有扎实的基础知识，为人积极向上，勇敢负责，吃苦耐劳，用于面对新事物，积极听取他人意见并及时修改错误。</td>
			</tr>
		</table>


	</div>

</body>
</html>
