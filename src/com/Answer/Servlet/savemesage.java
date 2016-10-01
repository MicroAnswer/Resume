package com.Answer.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Answer.Bean.Message;
import com.Answer.Bean.User;
import com.Answer.Database.DataBaseManager;
import com.Answer.Tools.Application;

public class savemesage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String messageContent = request.getParameter("mesg");
		
		if(messageContent==null || "".equals(messageContent)){
			response.getWriter().println("请输入内容");
		}else{
			HttpSession session = request.getSession();

			User u = (User) session.getAttribute("user");
			
			int user_id = 0;
			if(u!=null){
				user_id = u.getId();
			}
			
			DataBaseManager manager = Application.getdatabaseManager(session);
			Message msg = new Message();
			msg.setDate(new Date().toLocaleString());
			msg.setMessage(messageContent);
			msg.setUser_id(user_id);
			int addMessage = manager.addMessage(msg);
			if(addMessage>0){
				response.getWriter().println("留言成功");
			}else{
				response.getWriter().println("留言失败");
			}
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
