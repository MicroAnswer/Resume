<%@page import="com.Answer.Bean.Message"%>
<%@page import="com.Answer.Tools.Application"%>
<%@page import="com.Answer.Database.DataBaseManager"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="com.Answer.CustomSimpleTag" prefix="s"%>
<%-- <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	DataBaseManager manager = Application.getdatabaseManager(session);
	ArrayList<Message> l=manager.getAllMessage();
	pageContext.setAttribute("messages", l);
	pageContext.setAttribute("ssiizzee", l.size());
%> --%>

<!DOCTYPE>
<html>
<head>
<link rel="shortcut icon" href='<s:home/>/bg/fan.ico' />
<%-- <s:home/>/talk?pagenumber=1 --%>

<title>留言及评价</title>
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

.msg {
	width: 90%;
	margin: 12px auto 12px auto;
	border: #000000 solid 2px;
	padding: 10px;
}

.msgc {
	color: rgb(20, 20, 200);
	font-size: 17px;
	width: 98%;
	margin: 10px;
}

.deletebutton {
	background-color: #bbbbbb;
	border-radius: 3px;
	padding: 2px;
	margin-left: 12px;
	width: 16px;
	height: 16px;
}

.deletebutton:HOVER {
	background-color: #ff9999;
}

.deletebutton:ACTIVE {
	background-color: #ff2222;
}
</style>
<script type="text/javascript"
	src="http://www.w3school.com.cn/jquery/jquery.js"></script>
<script type="text/javascript">
	//删除一条留言
	function deleteMessage(messageId){
		var d = confirm("你真的要删除这条留言吗？");
		
		if(d){
			 $.get("<s:home/>/deletemessage?message_id="+messageId,function(data,status){
				 alert(data);
				 location.reload();
			    })
		}
	}
	
	//保存留言
	function saveMessage(){
		var btn = $("#submitmsgbtn");
		btn.attr("disabled", true); 
		btn.html("提交中...");
		
		var msgcont = $("#mesginput").val();
		
		if(msgcont==""){
			alert("请输入内容");
			btn.html("我要留言");
            btn.attr("disabled", false); 
			return;
		}
		
		$.ajax({
            type: "POST",
            url:'<s:home/>/savemesage',
            data:$('#msgform').serialize(),// 你的formid
            error: function(request) {
            	btn.html("我要留言");
                $("#resulthint").html("错误，留言失败 "+request.status).css("color","red");
                btn.attr("disabled", false); 
            },
            success: function(data) {
            	btn.html("我要留言");
            	btn.attr("disabled", false); 
            	$("#resulthint").html(data);
            	location.reload();
            }
        });
		
	}
</script>

</head>

<body>
	<s:main bgColor="#ffffff" mCustomStyle="height:auto">
		<span
			style="float: right; margin-top: -25px; margin-right: 20px; color: #ffffff;"><a
			href='<s:home/>/home.jsp' style="color: #ffffff;">返回主页</a> 【
			全部${page.messagecount }条留言】</span>
		<c:if test="${user == null }">
			<p
				style="color: red; width: 100%; text-align: center; margin-top: 5px;">
				您还没有登录，您只能进行匿名留言,<strong color="red">且不可删除</strong>
			</p>
		</c:if>
		<div
			style="margin: 6px auto 12px auto; width: 90%; padding: 10px; height: 250px; border: #000000 solid 2px;">
			<form method="post" id="msgform">
				<textarea cols="100" rows="11" id="mesginput"
					style="width: 100%; height: 80%; line-height: 20px; padding: 5px;"
					name="mesg"></textarea>
				<input name="pagenumber" value='  ${page.nowpage} '
					style="display: none" />
			</form>
			<button id="submitmsgbtn"
				style="margin-top: 10px; width: 100px; height: 40px; float: left;"
				onclick="saveMessage()">我要留言</button>
			<div id="resulthint"
				style="float: left; height: 40px; line-height: 40px; display: block; margin-top: 10px; margin-left: 10px; font-size: 15px;">
			</div>
		</div>
		<c:forEach var="m" items="${page.list}">
			<div class="msg">
				<p>
				<div>
					<span
						style="font-size: 10px; height: 10px; display: block; float: left;">#</span>
					<span
						style="font-size: 15px; height: 18px; width: 18px; line-height: 18px;">${m.floor}楼</span>
					<c:if test="${(user != null) && (user.id == m.user_id)}">
						<img class="deletebutton" src="bg/delete.png"
							onclick="javascript:deleteMessage(${m.message_id})" />
					</c:if>
				</div>
				<span style="color: #995599; font-size: 20px;"><s:MessageUser
						var="m" /></span>留言说：<span style="float: right;">${m.date }</span>
				</p>
				<hr />
				<p class="msgc" style="font-size: 20px;">
					<%-- <c:out value="${m.message }"></c:out> --%>
					${m.message }
				</p>
			</div>
		</c:forEach>
		<p style="width: 100%; text-align: center; margin-bottom: 12px;">
			<a href='<s:home/>/talk?pagenumber=${page.firstpage}'>首页</a> <a
				href='<s:home/>/talk?pagenumber=${page.lastpage}'>尾页</a> 第
			<c:if test="${page.allpage<=5 }">
				<c:forEach var="i" begin="1" end="${page.allpage }" step="1">
					<c:choose>
						<c:when test="${i == page.nowpage}">
						${page.nowpage}
					</c:when>
						<c:otherwise>
							<a href='<s:home/>/talk?pagenumber=${i}'>${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
			<c:if test="${page.allpage>5 }">
				<c:choose>
					<c:when test="${page.nowpage <=3 }">
						<c:forEach var="i" begin="1" end="5" step="1">
							<c:choose>
								<c:when test="${i == page.nowpage}">
						${page.nowpage}
					</c:when>
								<c:otherwise>
									<a href='<s:home/>/talk?pagenumber=${i}'>${i}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:when>
					<c:when test="${page.nowpage >=page.allpage-2 }">
						<c:forEach var="i" begin="${page.allpage-4 }"
							end="${page.allpage }" step="1">
							<c:choose>
								<c:when test="${i == page.nowpage}">
						${page.nowpage}
					</c:when>
								<c:otherwise>
									<a href='<s:home/>/talk?pagenumber=${i}'>${i}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach var="i" begin="${page.nowpage-2 }"
							end="${page.nowpage+2 }" step="1">
							<c:choose>
								<c:when test="${i == page.nowpage}">
						${page.nowpage}
					</c:when>
								<c:otherwise>
									<a href='<s:home/>/talk?pagenumber=${i}'>${i}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</c:if>
			页 共${page.allpage} 页 <a
				href='<s:home/>/talk?pagenumber=${page.uppage}'>上一页</a> <a
				href='<s:home/>/talk?pagenumber=${page.nextpage}'>下一页</a>
		</p>
	</s:main>
	<div
		style="width: 800px; height: 90px; background-color: #000000; margin: 10px auto 0px auto; text-align: center; color: #ffffff; padding-top: 10px;">
		<div style="margin-top: 10px">制作： 范雪蛟 QQ:374288225</div>
		电话：13541227014 <br />
		<s:showTime />

	</div>
</body>
</html>
