package com.Answer.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.Answer.Bean.DatabaseConfig;
import com.Answer.Bean.Message;
import com.Answer.Bean.User;
import com.Answer.Test.DatabaseTest;
import com.Answer.Tools.XmlTool;

public class DataBaseManager {
	private String name;
	private Connection con;
	private Statement stm;
	private ResultSet Rs;
	private PreparedStatement pstm;
	private DatabaseConfig config;

	public String getName() {
		return name;
	}

	public DataBaseManager(String name) {
		try {
			config = new XmlTool(new File(
					DatabaseTest.class.getClassLoader().getResource("config.xml").getPath().replace("%20", " ")))
							.getXmlConfig(1);
			Class.forName(config.getDatabaseDriver());

			this.name = name;
		} catch (Exception e) {

		}
	}

	// --------------------------------------------以下是对message表的操作---------------------------------------------------------
	/**
	 * 修改一条留言
	 * 
	 * @param m
	 * @return 受影响的条数
	 */
	public int UpdataMessage(Message m) {
		int i = -1;
		try {
			String sql = "update message set message = ? where message_id = ? ";
			con = getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, m.getMessage());
			pstm.setInt(2, m.getMessage_id());
			i = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	/**
	 * 删除一条留言
	 * 
	 * @param Message_id
	 * @return 删除的行数
	 */
	public int DeleteMessage(int Message_id) {
		int i = -1;
		try {
			String sql = "delete from message where message_id='" + Message_id + "'";
			stm = getsStatement();
			i = stm.executeUpdate(sql);
		} catch (Exception a) {
			a.printStackTrace();
		} finally {
			Close();
		}
		return i;
	}

	/**
	 * 添加一条留言
	 * 
	 * @param m
	 * @return 受影响的条数
	 */
	public int addMessage(Message m) {
		int i = -1;
		try {
			String sql = "insert into message (user_id,message,date) values(?,?,?)";
			con = getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, m.getUser_id());
			pstm.setString(2, m.getMessage());
			pstm.setString(3, new Date().toLocaleString());
			i = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		return i;
	}

	/**
	 * 通过ID获取留言
	 * 
	 * @param message_id
	 *            id
	 * @return Message对象
	 */
	public Message getMessage(int message_id) {
		Message m = null;
		try {
			String sql = "select * from message where message_id='" + message_id + "';";
			stm = getsStatement();
			Rs = stm.executeQuery(sql);
			if (haveData(Rs)) {
				int index = 1;
				do {
					m = getMessageFromResultSet(Rs, index++);
				} while (Rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		return m;
	}

	/**
	 * 分页查询时，调用该方法，返回一个页面要显示的数据
	 * 
	 * @param start
	 *            查询开始位置
	 * @param count
	 *            查询数据条数
	 * @return 数据集合
	 */
	public ArrayList<Message> getApageMessage(int start, int count) {
		ArrayList<Message> pm = null;
		try {
			String sql = "select * from message order by message_id ASC limit ? , ?";
			con = getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, (start - 1) * count);
			pstm.setInt(2, count);
			Rs = pstm.executeQuery();
			if (haveData(Rs)) {
				int index = 1;
				pm = new ArrayList<>();
				do {
					pm.add(getMessageFromResultSet(Rs, index++));
				} while (Rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}

		return pm;
	}

	/**
	 * 获取所有留言条数
	 * 
	 * @return
	 */
	public int getallMessageCount() {
		int i = -1;
		try {
			String sql = "select count(*) from message;";
			stm = getsStatement();
			Rs = stm.executeQuery(sql);
			if (haveData(Rs)) {
				i = Rs.getInt(1);
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return i;
	}

	/**
	 * 获取所有留言
	 * 
	 * @return 返回ArrayList<Message>集合
	 */
	public ArrayList<Message> getAllMessage() {
		ArrayList<Message> ml = new ArrayList<>();
		try {
			String sql = "select * from message order by message_id ASC;";
			stm = getsStatement();
			Rs = stm.executeQuery(sql);
			if (haveData(Rs)) {
				int index = 1;
				do {
					ml.add(getMessageFromResultSet(Rs, index++));
				} while (Rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return ml;
	}

	private Message getMessageFromResultSet(ResultSet R, int index) {
		Message m = null;
		try {
			m = new Message();
			m.setMessage_id(R.getInt("message_id"));
			m.setFloor(index);
			m.setDate(R.getString("date"));
			String replace = R.getString("message").replace("\r\n", "<br/>").replace("\n", "<br/>");

			while (replace.contains("<br/><br/>")) {
				replace = replace.replace("<br/><br/>", "<br/>");
			}

			m.setMessage(replace);
			m.setUser_id(R.getInt("user_id"));
		} catch (Exception a) {
			a.printStackTrace();
		}
		return m;
	}

	// -----------------------------------以下是对user表的操作-------------------------------------------------------

	/**
	 * 添加用户到数据库
	 * 
	 * @param u
	 */
	public int addUser(User u) {
		int i = -1;
		try {
			String sql = "insert into users (name,password,sex,qq,tel,addr,birthday,info,email,age) values('"
					+ u.getName() + "','" + u.getPassword() + "','" + u.getSex() + "','" + u.getQQ() + "','"
					+ u.getTel() + "','" + u.getAddr() + "','" + u.getBirthday() + "','" + u.getInfo() + "','"
					+ u.getEmail() + "','" + u.getAge() + "');";
			stm = getsStatement();
			i = stm.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return i;
	}

	/**
	 * 检测密码是否正确
	 * 
	 * @return
	 */
	public boolean passWordRight(String name, String password) {
		if (Exist(name)) {
			try {
				String sql = "select * from users where name=?";
				PreparedStatement p = getConnection().prepareStatement(sql);
				p.setString(1, name);
				Rs = p.executeQuery();
				// Rs = stm.executeQuery(sql);
				if (haveData(Rs)) {
					if (Rs.first()) {
						do {
							if (Rs.getString("password").equals(password)) {
								return true;
							} else {
								return false;
							}
						} while (Rs.next());
					}
				} else {
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 获取一个用户
	 * 
	 * @return
	 */
	public User getUser(String name, String password) {
		User u = null;
		try {
			String sql = "select * from users where name ='" + name + "' and password='" + password + "';";
			stm = getsStatement();
			Rs = stm.executeQuery(sql);
			if (haveData(Rs)) {
				do {
					u = getUserInRs(Rs);
				} while (Rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return u;
	}

	/**
	 * 获取一个用户
	 * 
	 * @return
	 */
	public User getUser(int id) {
		User u = null;
		try {
			String sql = "select * from users where id ='" + id + "';";
			stm = getsStatement();
			Rs = stm.executeQuery(sql);
			if (haveData(Rs)) {
				do {
					u = getUserInRs(Rs);
				} while (Rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return u;
	}

	/**
	 * 查询用户是否存在
	 * 
	 * @param name
	 * @return
	 */
	public boolean Exist(String name) {
		try {
			String sql = "select * from users where name = '" + name + "';";
			stm = getsStatement();
			Rs = stm.executeQuery(sql);
			if (haveData(Rs)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return false;
	}

	/**
	 * 升级用户信息
	 * 
	 * @param u
	 */
	public int UpdataUser(User u) {
		int i = -1;
		try {
			String sql = "update users set name = '" + u.getName() + "', password = '" + u.getPassword() + "', tel = '"
					+ u.getTel() + "', sex = '" + u.getSex() + "', qq = '" + u.getQQ() + "', addr = '" + u.getAddr()
					+ "', age = '" + u.getAge() + "', birthday = '" + u.getBirthday() + "', email='" + u.getEmail()
					+ "',head='" + u.getHead() + "',info='" + u.getInfo() + "' where id = '" + u.getId() + "';";
			stm = getsStatement();
			i = stm.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return i;
	}

	/**
	 * 删除用户
	 * 
	 * @param name
	 * @param password
	 */
	public int DeleteUser(int id) {
		int i = -1;
		try {
			String sql = "delete from users where id='" + id + "';";
			stm = getsStatement();
			i = stm.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Close();
		}
		return i;
	}

	/**
	 * 获取所有用户
	 * 
	 * @return List<User> 集合
	 */
	public ArrayList<User> getAllUser() {
		ArrayList<User> users = new ArrayList<>();
		try {
			String sql = "select * from users;";
			stm = getsStatement();
			Rs = stm.executeQuery(sql);
			if (haveData(Rs)) {
				if (Rs.first()) {
					do {
						users.add(getUserInRs(Rs));
					} while (Rs.next());
				}
			}
		} catch (Exception a) {
			a.printStackTrace();
		} finally {
			Close();
		}
		return users;
	}

	/**
	 * 返回所有用户个数
	 * 
	 * @return Long
	 */
	public long getAllUserCount() {
		return getAllUser().size();
	}

	/**
	 * 从定义好的ResultSet中获取游标所处的用户
	 * 
	 * @param r
	 * @return User u
	 */
	private User getUserInRs(ResultSet r) {
		User u = null;
		BufferedReader brd = null;
		Reader rd = null;
		try {
			u = new User();
			u.setId(r.getInt("id"));
			u.setName(r.getString("name"));
			u.setPassword(r.getString("password"));
			u.setSex(r.getInt("sex"));
			u.setAge(r.getInt("age"));
			u.setQQ(r.getString("qq"));
			u.setEmail(r.getString("email"));
			u.setAddr(r.getString("addr"));
			u.setTel(r.getString("tel"));
			u.setBirthday(r.getString("birthday"));
			u.setHead(r.getString("head"));
			StringBuffer info = new StringBuffer();
			rd = r.getCharacterStream("info");
			brd = new BufferedReader(rd);
			String s = new String();
			while ((s = brd.readLine()) != null) {
				info.append(s);
			}
			u.setInfo(info.toString());
		} catch (Exception a) {
			a.printStackTrace();
		} finally {
			try {
				rd.close();
				brd.close();
			} catch (Exception a) {
				a.printStackTrace();
			} finally {
				rd = null;
				brd = null;
			}
		}
		return u;
	}

	/**
	 * 获取SQL语句执行对象
	 * 
	 * @return
	 */
	private Statement getsStatement() {
		try {
			return getConnection().createStatement();
		} catch (Exception a) {
			a.printStackTrace();
			// Close();
		}
		return null;
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(config.getDatabaseUrl(), config.getDatabaseUserName(),
				config.getDatabaseUserPassword());
	}

	/**
	 * 关闭与数据库有关的连接
	 */
	private void Close() {
		try {
			if (con != null) {
				con.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (Rs != null) {
				Rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// con = null;
			stm = null;
			Rs = null;
			pstm = null;
			// souce=null;
		}
	}

	/**
	 * 判断结果集是否有数据
	 * 
	 * @param R
	 * @return
	 */
	private boolean haveData(ResultSet R) {
		try {
			if (R != null) {
				if (!R.wasNull()) {
					R.last();
					if (R.getRow() > 0) {
						R.first();
						return true;
					} else {
						return false;
					}

				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
