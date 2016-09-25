<%@page import="com.Answer.Bean.BaiduShare"%>
<%@page import=" java.io.*"%>
<%@page import="com.Answer.Bean.WebFile"%>
<%@page import="com.Answer.Database.FileDatabaseManager"%>
<%@page import="com.Answer.Tools.Application"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="com.Answer.CustomSimpleTag" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//下面开始初始化（文件数据）
	FileDatabaseManager Fmanager = Application.getFiledatabaseManager(session);

	File rootf = new File("E:/software/");
	File[] files = rootf.listFiles(new FileFilter() {
		public boolean accept(File pathname) {
			return pathname.canRead() && (!pathname.isHidden()) && pathname.isFile();
		}
	});

	ArrayList<WebFile> fl = new ArrayList<WebFile>();
	ArrayList<BaiduShare> bl = new ArrayList<BaiduShare>();
	for (int i = 0; i < files.length; i++) {
		File f = files[i];
		WebFile e = new WebFile();
		e.setFileName(f.getName());
		e.setFileDownloadTimes(0);
		e.setFilePath(f.getAbsolutePath());
		if ((i + 1) < 38) {
			e.setFilePicPath("./file/filebg/" + (i + 1) + (((i + 1) >= 34 && (i + 1) <= 38 ? ".png" : ".jpg")));
		} else {
			e.setFilePicPath("./bg/f.jpg");
		}
		e.setId(i + 1);
		fl.add(e);
	}
	pageContext.setAttribute("shares", bl);
	pageContext.setAttribute("files", fl);
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

body * {
	margin: 0px;
	padding: 0px;
	font-family: microsoft yahei;
	border-radius: 5px;
}

.insidebox {
	margin: 14px;
	width: auto;
	height: auto;
}

.ul1 li {
	margin-bottom: 10px;
	margin-top: 10px;
	padding-right: 15px;
	list-style: none;
	padding-right: 15px;
}

.ul1 li a {
	display: block;
	width: 100%;
	background-color: #bbbbbb;
	padding-top: 8px;
	padding-left: 15px;
	padding-bottom: 8px;
	text-decoration: none;
}

.ul1 li a:HOVER {
	background: rgba(55, 55, 55, 0.6);
}
</style>
<title>软件下载</title>
</head>

<body>
	<s:main bgColor="#ffffff" mCustomStyle="height:auto">
		<a href='<s:home/>/home.jsp'
			style="float: right; margin-top: -25px; color: #ffffff; margin-right: 20px;">返回主页</a>
		<div class="insidebox">
			<p
				style="font-size: 30px; border-bottom: #555555 solid 2px; border-radius: 0px 0px 0px 0px; margin-bottom: 14px;">所有可下载的软件</p>
			<ul class="ul1">
				<c:forEach var="file" items="${files}">
					<li><a href='<s:home/>/filedownload?path=${file.filePath}'>${file.fileName}</a></li>
				</c:forEach>
			</ul>

		</div>

	</s:main>
	<div
		style="width: 800px; height: 90px; background-color: #000000; margin: 10px auto 0px auto; text-align: center; color: #ffffff; padding-top: 10px;">
		制作： 范雪蛟<br />Answer QQ:374288225<br />电话：13541227014 <br />
		<s:showTime />
	</div>
</body>
</html>
