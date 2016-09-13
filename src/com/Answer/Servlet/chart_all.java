package com.Answer.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.Answer.Tools.Application;
import com.Answer.Tools.Application.U;

/**
 * Servlet implementation class chart_all
 */
public class chart_all extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, U> chartU;

	public chart_all() {
		super();
		chartU = Application.getAllChartU();
	}

	/**
	 * 该servlet处理多个请求：不同请求通过指定不同function来区分<br/>
	 * 共有如下功能：<br/>
	 * <ul>
	 * <li>allusers：获取所有在线用户</li>
	 * <li>myinfo：获取我的在线信息</li>
	 * <li>setmyinfo：设置我的在线信息【chartname和chartsex】</li>
	 * <li>sendto：发消息给某人【chartname（目标对象昵称）和chartmessage（消息内容）】</li>
	 * <li>exit：退出聊天</li>
	 * </ul>
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String function = request.getParameter("function");
		if (null == function || function.equalsIgnoreCase("")) {
			// 拒绝空请求
			response.getWriter().append(ERROR_MSG.replace("服务器故障，请重试。", "非法请求。")).flush();
			return;
		} else {
			String result = ERROR_MSG;
			PrintWriter writer = response.getWriter();
			// 执信任务
			if ("allusers".equalsIgnoreCase(function)) {
				// 获取所有在线人的信息
				result = getallU();
			} else if ("myinfo".equalsIgnoreCase(function)) {
				// 我的信息
				result = getMyU(request);
			} else if ("setmyinfo".equalsIgnoreCase(function)) {
				// 设置我的信息
				result = setU(request);
			} else if ("sendto".equalsIgnoreCase(function)) {
				// 发消息给某人

				
			} else if ("exit".equalsIgnoreCase(function)) {
				// 退出聊天
				result = exitU(request);
			} else {
				result = result.replace("服务器故障，请重试。", "非法请求。");
			}
			
			writer.append(result).flush();
		}
	}

	/**
	 * 退出登录
	 * @param request
	 * @return
	 */
	private String exitU(HttpServletRequest request) {
		U u = (U) request.getSession().getAttribute("chart");
		JSONObject jo = new JSONObject();
		if (u == null) {// 没有登录过的退出

		} else {
			u = chartU.remove(u.name);
		}
		try {
			jo.put(JSON_KET_STATUS, true);
			jo.put(JSON_KEY_MSG, "退出成功");
			return jo.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR_MSG;
	}

	/**
	 * 获取我的聊天信息
	 * 
	 * @return
	 */
	private String getMyU(HttpServletRequest request) {
		JSONObject jsonobject = new JSONObject();
		U u = (U) request.getSession().getAttribute("chart");
		try {
			if (u != null) {
				jsonobject.put(JSON_KET_STATUS, true);
				jsonobject.put(JSON_KEY_MSG, "获取成功");

				JSONObject ji = new JSONObject();

				ji.put(JSON_KEY_NAME, u.name);
				ji.put(JSON_KEY_SEX, u.sex);

				jsonobject.put(JSON_KEY_DATA, ji);
			} else {
				jsonobject.put(JSON_KET_STATUS, false);
				jsonobject.put(JSON_KEY_MSG, "获取失败，没有创建聊天用户");
			}
			return jsonobject.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR_MSG;
	}

	/**
	 * 获取所有在线用户
	 * 
	 * @return
	 */
	private String getallU() {
		JSONObject jo = new JSONObject();
		try {
			jo.put(JSON_KET_STATUS, true);

			Set<Entry<String, U>> entrySet = chartU.entrySet();

			JSONArray jar = new JSONArray();
			for (Entry<String, U> entry : entrySet) {
				JSONObject j = new JSONObject();
				j.put(JSON_KEY_NAME, entry.getValue().name);
				j.put(JSON_KEY_SEX, entry.getValue().sex);
				jar.put(j);
			}
			jo.put(JSON_KEY_DATA, jar);
			jo.put(JSON_KEY_MSG, "获取成功");
			return jo.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR_MSG;
	}

	/**
	 * 添加一个聊天用户
	 * 
	 * @param name
	 * @param sex
	 * @return
	 */
	private String setU(HttpServletRequest request) {
		JSONObject j = new JSONObject();
		String name = request.getParameter("chartname");
		String sex = request.getParameter("chartsex");
		try {
			if (name == null || name.length() < 1) {
				j.put(JSON_KET_STATUS, false);
				j.put(JSON_KEY_MSG, "请填写你的名字。");
				return j.toString();
			}

			if (request.getSession().getAttribute("chart") != null) {// 一个seesion只能创建一个聊天用户
				j.put(JSON_KET_STATUS, false);
				j.put(JSON_KEY_MSG, "不能创建第二个账户");
				return j.toString();
			}

			if (chartU.containsKey(name)) {// 服务器已有该名称的聊天用户
				j.put(JSON_KET_STATUS, false);
				j.put(JSON_KEY_MSG, "该用户名已存在，请更换其它的用户名。");
				return j.toString();
			}

			U u = new U();
			u.name = name;
			u.sex = (sex == null || sex.length() < 1) ? "未设置" : sex;
			request.getSession().setAttribute("chart", u);
			chartU.put(name, u);

			j.put(JSON_KET_STATUS, true);
			j.put(JSON_KEY_MSG, "创建成功");
			return j.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR_MSG;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private static final String JSON_KEY_MSG = "msg";
	private static final String JSON_KET_STATUS = "status";
	private static final String JSON_KEY_DATA = "data";
	private static final String JSON_KEY_NAME = "name";
	private static final String JSON_KEY_SEX = "sex";
	private static final String ERROR_MSG = "{\"" + JSON_KET_STATUS + "\":false,\"" + JSON_KEY_MSG + "\":\"服务器故障，请重试。\"}";
}
