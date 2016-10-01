package com.Answer.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Answer.Bean.Message;
import com.Answer.Bean.User;
import com.Answer.Database.DataBaseManager;
import com.Answer.Tools.Application;

/**
 * 删除一条留言 Servlet implementation class deletemessage
 */
public class deletemessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deletemessage() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		int message_id = -1;
		try {
			message_id = Integer.parseInt(request.getParameter("message_id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		DataBaseManager manager = Application.getdatabaseManager(session);
		User u = (User) session.getAttribute("user");

		Message msg = manager.getMessage(message_id);
		if (msg != null) {
			if ((u != null) && (u.getId() == msg.getUser_id())) {
				int c = manager.DeleteMessage(message_id);

				if (c > 0) {
					response.getWriter().println("删除成功");
				} else {
					response.getWriter().println("删除失败");
				}

			} else {
				response.getWriter().println("不可信身份的删除操作，删除未成功");
			}
		} else {
			response.getWriter().println("不能删除不存在的留言");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
