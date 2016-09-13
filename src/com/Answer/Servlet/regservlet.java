package com.Answer.Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.Answer.Bean.User;
import com.Answer.Database.DataBaseManager;
import com.Answer.Exception.UserInfoException;
import com.Answer.Tools.Application;

public class regservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String checkNum = request.getParameter("checkNum").toLowerCase();
		String RcheckNum = request.getSession().getAttribute("checkNum")
				.toString().toLowerCase();
		User u = new User();
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String qq = request.getParameter("QQ");
		String tel = request.getParameter("Tel");
		String addr = request.getParameter("addr");
		String name = request.getParameter("Name");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String password = request.getParameter("Password");
		if (RcheckNum.equals(checkNum)) {
			request.getSession().removeAttribute("checkNum");
			// TODO验证码正确
			DataBaseManager manager = Application.getdatabaseManager(request
					.getSession());
			if (manager.Exist(name)) {
				request.setAttribute("hint", "用户名已存在，请重新起一个名字");
				request.setAttribute("Name", name+"01");
				request.setAttribute("birthday", birthday);
				request.setAttribute("QQ", qq);
				request.setAttribute("Tel", tel);
				request.setAttribute("email", email);
				request.setAttribute("addr", addr);
				request.getRequestDispatcher("/reg.jsp").forward(request,
						response);
			} else {
				try {
					u.setAddr(addr);
				//	u.setAge(age);
					u.setBirthday(birthday);
					u.setEmail(email);
					u.setName(name);
					u.setPassword(password);
					u.setQQ(qq);
					u.setSex(sex);
					u.setTel(tel);
					u.setInfo("这是一个用户：注册日期："+new Date().toLocaleString());
					System.out.println("--->"+u);
				} catch (Exception e1) {
					System.out.println(u);
				}
				try {
					u.CheckInfo();
				} catch (UserInfoException e) {
					request.setAttribute("hint", e.getMessage());
					request.setAttribute("Name", name);
					request.setAttribute("birthday", birthday);
					request.setAttribute("QQ", qq);
					request.setAttribute("Tel", tel);
					request.setAttribute("email", email);
					request.setAttribute("addr", addr);
					request.getRequestDispatcher("/reg.jsp").forward(request, response);
					return;
				}
				if (manager.addUser(u) > 0) {
					// TODO 注册成功
					response.setHeader("refresh",
							"2;url=" + request.getContextPath() + "/home.jsp");
					request.getSession().setAttribute("user", manager.getUser(name, password));
					request.getRequestDispatcher("/regok.jsp").forward(request,
							response);
				} else {
					request.setAttribute("hint", "注册失败");
					request.getRequestDispatcher("/reg.jsp").forward(request,
							response);
					// TODO 注册失败
				}
			}
		} else {
			request.setAttribute("Name", name);
			request.setAttribute("birthday", birthday);
			request.setAttribute("QQ", qq);
			request.setAttribute("Tel", tel);
			request.setAttribute("hint", "验证码不正确");
			request.setAttribute("email", email);
			request.setAttribute("addr", addr);
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
			// TODO验证码不正确
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
