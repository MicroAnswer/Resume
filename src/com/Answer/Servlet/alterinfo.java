package com.Answer.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Answer.Bean.User;
import com.Answer.Database.DataBaseManager;
import com.Answer.Tools.Application;

public class alterinfo extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String QQ = request.getParameter("QQ");
			String email = request.getParameter("email");
			String addr = request.getParameter("addr");
			String tel = request.getParameter("tel");
			String birthday = request.getParameter("birthday");
			String info = request.getParameter("info");
			User u = (User) request.getSession().getAttribute("user");
			u.setQQ(QQ);
			u.setEmail(email);
			u.setAddr(addr);
			u.setTel(tel);
			u.setBirthday(birthday);
			u.setInfo(info);
			System.out.println(u);
			DataBaseManager m = Application.getdatabaseManager(request.getSession());
			if(m.UpdataUser(u)>0){
				request.getRequestDispatcher("/me.jsp").forward(request, response);
			}else{
				request.setAttribute("hint", "修改失败");
				request.getRequestDispatcher("/alterme.jsp").forward(request, response);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request, response);
	}

}
