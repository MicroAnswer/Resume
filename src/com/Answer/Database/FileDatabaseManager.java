package com.Answer.Database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Answer.Bean.BaiduShare;
import com.Answer.Bean.DatabaseConfig;
import com.Answer.Bean.WebFile;
import com.Answer.Test.DatabaseTest;
import com.Answer.Tools.XmlTool;

public class FileDatabaseManager {
	private Connection con;
	private PreparedStatement stm;
	private ResultSet Rs;
	private  DatabaseConfig config;
	public FileDatabaseManager() {
		try {
			config = new XmlTool(new File(
					DatabaseTest.class.getClassLoader().getResource("config.xml").getPath().replace("%20", " ")))
							.getXmlConfig(1);
			Class.forName(config.getDatabaseDriver());
		} catch (Exception a) {
			a.printStackTrace();
		}
	}
	public WebFile getFile(int Fileid) {
		WebFile f = null;
		try {
			String sql = "select * from file where f_id=?;";
			con = getConnection();
			stm = con.prepareStatement(sql);
			stm.setInt(1, Fileid);
			Rs = stm.executeQuery();
			if (Rs != null) {
				if (Rs.first()) {
					do {
						String name = Rs.getString("f_name");
						int id = Rs.getInt("f_id");
						String path = Rs.getString("f_path");
						int times = Rs.getInt("f_download_times");
						String picpath = Rs.getString("f_pic_path");
						f = new WebFile();
						f.setFileDownloadTimes(times);
						f.setFileName(name);
						f.setFilePicPath(picpath);
						f.setId(id);
						f.setFilePath(path);
					} while (Rs.next());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		return f;
	}

	/**
	 * 获取指定分享信息
	 * 
	 * @return
	 */
	public BaiduShare getAllShare(int ida) {
		BaiduShare s = null;
		try {
			String sql = "select * from share where s_id = ?";
			con = getConnection();
			stm = con.prepareStatement(sql);
			stm.setInt(1, ida);
			Rs = stm.executeQuery();
			if (Rs != null)
				if (Rs.first()) {
					do {
						int id = Rs.getInt("s_id");
						String name = Rs.getString("s_name");
						String url = Rs.getString("s_url");
						s = new BaiduShare();
						s.setId(id);
						s.setName(name);
						s.setUrl(url);
					} while (Rs.next());
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		return s;
	}

	/**
	 * 获取所有分享信息
	 * 
	 * @return
	 */
	public ArrayList<BaiduShare> getAllShare() {
		ArrayList<BaiduShare> Bl = new ArrayList<>();
		try {
			String sql = "select * from share;";
			con = getConnection();
			stm = con.prepareStatement(sql);
			Rs = stm.executeQuery();
			if (Rs != null)
				if (Rs.first()) {
					do {
						int id = Rs.getInt("s_id");
						String name = Rs.getString("s_name");
						String url = Rs.getString("s_url");
						BaiduShare s = new BaiduShare();
						s.setId(id);
						s.setName(name);
						s.setUrl(url);
						Bl.add(s);
					} while (Rs.next());
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		return Bl;
	}

	/**
	 * 获取所有下载信息
	 * 
	 * @return
	 */
	public ArrayList<WebFile> getAllFile() {
		ArrayList<WebFile> fl = new ArrayList<>();
		try {
			String sql = "select * from file";
			con = getConnection();
			stm = con.prepareStatement(sql);
			Rs = stm.executeQuery();
			if (Rs != null) {
				if (Rs.first()) {
					do {
						String name = Rs.getString("f_name");
						int id = Rs.getInt("f_id");
						String path = Rs.getString("f_path");
						int times = Rs.getInt("f_download_times");
						String picpath = Rs.getString("f_pic_path");
						WebFile f = new WebFile();
						f = new WebFile();
						f.setFileDownloadTimes(times);
						f.setFileName(name);
						f.setFilePicPath(picpath);
						f.setId(id);
						f.setFilePath(path);
						fl.add(f);
					} while (Rs.next());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return fl;
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 * @throws SQLException 
	 */
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(config.getDatabaseUrl(),config.getDatabaseUserName(),config.getDatabaseUserPassword());
	}

	/**
	 * 关闭与数据库有关的连接
	 */
	private void Close() {
		try {
			if (con != null) {
				if (!con.isClosed()) {
					con.close();
				}
			}
			if (stm != null) {
				stm.close();
			}
			if (Rs != null) {
				Rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con = null;
			stm = null;
			Rs = null;
		}
	}
}
