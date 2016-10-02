package com.Answer.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Answer.Bean.Message;
import com.Answer.Bean.MessagePage;
import com.Answer.Database.DataBaseManager;
import com.Answer.Tools.Application;

public class talk extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			DataBaseManager manager = Application.getdatabaseManager(request.getSession());
			int pagenumber;
			try{
			pagenumber = Integer.parseInt((""+request.getAttribute("pagenumber")).trim());}catch(Exception e){pagenumber=0;}
			// 获取当前页码
			pagenumber = (pagenumber == 0 ? Integer.parseInt(request.getParameter("pagenumber").trim()) : pagenumber);
			// 设定每一页显示条数
			int messagecount = 10;
			// 创建页面数据
			MessagePage page = new MessagePage();
			page.setFirstpage(1);
			int t = manager.getallMessageCount();
			page.setMessagecount(t);
			int pagecount = t / messagecount + (t % messagecount == 0 ? 0 : 1);
			page.setLastpage(pagecount);
			
			pagenumber = pagenumber>pagecount?pagecount:pagenumber;
			
			page.setAllpage(pagecount);
			ArrayList<Message> apageMessage = manager.getApageMessage(pagenumber, messagecount);
			page.setList(apageMessage);
			page.setNextpage(pagenumber >= pagecount ? pagecount : pagenumber + 1);
			page.setUppage(pagenumber <= 1 ? 1 : pagenumber - 1);
			page.setNowpage(pagenumber);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/talk.jsp").forward(request, response);
		} catch (Exception a) {
			a.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
