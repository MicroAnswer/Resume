package com.Answer.Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;

import com.Answer.Tools.Application;
import com.Answer.Tools.Application.U;

@ServerEndpoint("/chartserver/{chatname}/{chartsex}")
public class ChartServer {

	private Session session;
	private String name;

	public Session getSession() {
		return session;
	}

	public String getName() {
		return name;
	}

	@OnOpen
	public void open(@PathParam("chatname") String chatname, @PathParam("chatsex") String chatsex, Session session) {
		// 添加初始化操作
		// String id = session.getId();
		name = chatname;
		// String sex = chatsex.equals("0") ? "女" : "男";
		U u = Application.getAllChartU().get(name);
		if (u == null) {
			return;
		}
		this.session = session;
		u.setChartServer(this);
		HashMap<String, U> allChartU = Application.getAllChartU();
		Set<Entry<String, U>> entrySet = allChartU.entrySet();
		for (Entry<String, U> entry : entrySet) {

			Session session2 = entry.getValue().getChartServer().getSession();
			if (session2 != null) {
				try {
					JSONObject jo = new JSONObject();
					jo.put("type", "nus");
					jo.put("name", name);
					session2.getBasicRemote().sendText(jo.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * @param message
	 *            客户端发来的消息
	 * @param session
	 *            客户端的会话
	 */
	@OnMessage
	public void getMessage(String message, Session session) {
		JSONObject jsonobject = null;
		String tar = null;
		try {
			jsonobject = new JSONObject(message);
			tar = jsonobject.getString("tar");
			jsonobject.put("type", "msg");
			U u = Application.getAllChartU().get(tar);
			Session session2 = u.getChartServer().getSession();
			if (session2 != null) {
				session2.getBasicRemote().sendText(jsonobject.toString());
			} else {
				jsonobject.put("msg", "对方没在线");
				jsonobject.put("tar", jsonobject.get("src"));
				jsonobject.put("src", tar);
				session.getBasicRemote().sendText(jsonobject.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				jsonobject.put("msg", "对方没在线");
				jsonobject.put("tar", jsonobject.get("src"));
				jsonobject.put("src", tar);
				session.getBasicRemote().sendText(jsonobject.toString());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	@OnClose
	public void close() {
		HashMap<String, U> allChartU = Application.getAllChartU();
		Set<Entry<String, U>> entrySet = allChartU.entrySet();
		for (Entry<String, U> entry : entrySet) {

			ChartServer cs = entry.getValue().getChartServer();
			if (cs == null || cs == this) {
				continue;
			}
			Session session2 = cs.getSession();
			if (session2 != null) {
				try {
					JSONObject jo = new JSONObject();
					jo.put("type", "uus");
					jo.put("name", name);
					session2.getBasicRemote().sendText(jo.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@OnError
	public void error(Throwable t) {
		// 添加处理错误的操作
		System.out.println("错误：" + t.getMessage());
		close();
	}

}
