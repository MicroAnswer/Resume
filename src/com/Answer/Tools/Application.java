package com.Answer.Tools;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.Answer.Database.DataBaseManager;

public class Application {
	public static final String DatabaseManager = "databaseManager";
	public static final String FileDatabaseManager = "filemanager";

	private static HashMap<String, U> chart_U = null;

	static {
		if (chart_U == null) {
			chart_U = new HashMap<>();
		}
	}

	/**
	 * 获取聊天用户容器
	 * 
	 * @return
	 */
	public static final HashMap<String, U> getAllChartU() {
		if (chart_U == null) {
			chart_U = new HashMap<>();
		}
		return chart_U;
	}

	/**
	 * 从session中拿到数据库管理员，如果没有创建一个
	 * 
	 * @param session
	 * @return
	 */
	public static final DataBaseManager getdatabaseManager(HttpSession session) {
		DataBaseManager manager = (DataBaseManager) session.getAttribute(DatabaseManager);
		if (manager == null) {
			manager = new DataBaseManager(session.getClass().getName());
			session.setAttribute(DatabaseManager, manager);
		}
		return manager;
	}

	/**
	 * 从session中拿到文件数据库管理员，如果没有创建一个
	 * 
	 * @param session
	 * @return
	 */
	public static final com.Answer.Database.FileDatabaseManager getFiledatabaseManager(HttpSession session) {
		com.Answer.Database.FileDatabaseManager manager = (com.Answer.Database.FileDatabaseManager) session
				.getAttribute(FileDatabaseManager);
		if (manager == null) {
			manager = new com.Answer.Database.FileDatabaseManager();
			session.setAttribute(FileDatabaseManager, manager);
		}
		return manager;
	}

	// public static Connection getConnection() {
	// Connection connection = null;
	// try {
	// connection = getc.getConnection();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return connection;
	// }

	/**
	 * 聊天的用户对象
	 * 
	 * @author Micro
	 *
	 */
	public static final class U {
		public String name;
		public String sex;
	}

}
