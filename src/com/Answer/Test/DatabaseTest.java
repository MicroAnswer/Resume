package com.Answer.Test;

import java.util.ArrayList;
import java.util.Iterator;

import com.Answer.Bean.Message;
import com.Answer.Bean.User;
import com.Answer.Database.DataBaseManager;

public class DatabaseTest {

	public static void main(String[] a) {
		DataBaseManager m = new DataBaseManager("测试管理");
//		Message m2 = new Message();
		//m2.setMessage("看看书，谢谢代码，做做运动。哈哈哈，快乐每一天");
//		m2.setUser_id(51);
//		for (int i =0; i <100; i++) {
			//m2.setMessage(m2.getMessage() + ":" + i);
			//m.addMessage(m2);
			//m.DeleteMessage(i);
//			m2.setMessage("看看书，谢谢代码，做做运动。哈哈哈，快乐每一天");
//			m.addMessage(m2);
//		}
		// System.out.println(m.passWordRight("范雪蛟", "123456"));
		// System.out.println(m.Exist("范雪蛟"));
		// System.out.println("已删除"+m.DeleteUser((int)m.getAllUserCount())+"个");
		// System.out.println(m.getUser("范雪蛟","123456"));
		// for (int i = 0; i < 20; i++) {
		// User u = new User();
		// u.setName("刘德华");
		// u.setBirthday("1992-6-6");
		// u.setPassword("123987546");
		// u.setAddr("四川省资阳市");
		// u.setEmail("www.3215466@loi.com");
		// u.setAge(23);
		// u.setQQ("374255886");
		// u.setTel("1236547894");
		// u.setSex(1);
		// m.addUser(u);
		// }
		boolean exist = m.passWordRight("范雪蛟", "123456");
		System.out.println(exist);
	}

}
