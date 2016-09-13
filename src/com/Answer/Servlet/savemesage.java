package com.Answer.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Answer.Bean.Message;
import com.Answer.Bean.User;
import com.Answer.Database.DataBaseManager;
import com.Answer.Tools.Application;

public class savemesage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String message = request.getParameter("mesg");
		if ("".equals(message)) {
			request.setAttribute("pagenumber", request.getParameter("pagenumber"));
			request.getRequestDispatcher("/talk").forward(request, response);
			return;
		}
		User u = (User) request.getSession().getAttribute("user");
		int user_id=0;
		if (u == null) {
			user_id = 0;
		}else{
			user_id=u.getId();
		}
		Message m = new Message();
		m.setMessage(message);
		m.setUser_id(user_id);
//		System.out.println(message);
		DataBaseManager manager = Application.getdatabaseManager(request
				.getSession());
		if (manager.addMessage(m) > 0) {
			request.setAttribute("hint", "<a style='color:green'>留言成功</a>");
		} else {
			request.setAttribute("hint", "<a style='color:red'>留言失败，请稍后再试</a>");
		}
//		response.sendRedirect(getServletContext().getContextPath()+"/talk?pagenumber=1");
		request.setAttribute("pagenumber", request.getParameter("pagenumber"));
		request.getRequestDispatcher("/talk").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
