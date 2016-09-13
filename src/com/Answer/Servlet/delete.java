package com.Answer.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Answer.Database.DataBaseManager;
import com.Answer.Tools.Application;

public class delete extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int deleteId =Integer.parseInt(request.getParameter("id"));
		DataBaseManager manager = Application.getdatabaseManager(request.getSession());
		int n = manager.DeleteUser(deleteId);
		if(0<n){
			request.setAttribute("hint", "成功删除了"+n+"个用户");
		}else{
			request.setAttribute("hint", "删除失败");
		}
		request.getRequestDispatcher("/delete.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request, response);
	}

}
