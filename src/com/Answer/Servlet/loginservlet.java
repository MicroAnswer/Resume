package com.Answer.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Answer.Bean.User;
import com.Answer.Database.DataBaseManager;
import com.Answer.Tools.Application;

/**
 * 响应用户登录请求的Servlet
 * 
 * @author Answer
 * 
 */
public class loginservlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String checkNum = request.getParameter("checkNum").toLowerCase();
		String name = request.getParameter("Name");
		String password = request.getParameter("Password");
		String RcheckNumber =( (String) request.getSession().getAttribute(
				"checkNum")).toLowerCase();
		if (checkNum.equals(RcheckNumber)) {
			// TODO 验证码正确
			DataBaseManager manager = Application.getdatabaseManager(request
					.getSession());
			if (manager.passWordRight(name, password)) {
				// TODO 登陆成功
				User u = manager.getUser(name, password);
				request.getSession().setAttribute("user", u);
				request.getSession().removeAttribute("checkNum");
				request.getRequestDispatcher("/home.jsp").forward(request,
						response);
			} else {
				request.setAttribute("Name", name);
				request.setAttribute("Password", password);
				request.setAttribute("hint", "用户名或密码不正确");
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			}
		} else {
			request.setAttribute("Name", name);
			request.setAttribute("Password", password);
			request.setAttribute("hint", "验证码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
