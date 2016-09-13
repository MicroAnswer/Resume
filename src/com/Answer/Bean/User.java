package com.Answer.Bean;

import java.io.Serializable;

import com.Answer.Exception.UserInfoException;

public class User implements Serializable {
	/**
	 * 
	 */
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private static final long serialVersionUID = 1L;
	private String Name;
	private String Password;
	private int Age;
	private int sex;
	private String addr;
	private String QQ;
	private String Tel;
	private String email;
	private String birthday;
	private String head;
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return Name + "-" + Password + "-" + Age + "-" + sex + "-" + email
				+ "-" + QQ + "-" + Tel + "-" + birthday+"-"+head;
	}


	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void CheckInfo() throws UserInfoException {
		if (Name == null || "".equals(Name)) {
			throw new UserInfoException("用户名不能为空");
		}
		if (Password == null || "".equals(Password)) {
			throw new UserInfoException("密码不能为空");
		}
		if (addr == null || "".equals(addr)) {
			throw new UserInfoException("地址不能为空");
		}
		if (QQ == null || "".equals(QQ)) {
			throw new UserInfoException("QQ不能为空");
		}
		if (!email.matches("^\\w+@\\w+(\\.\\w+)+$")) {
			throw new UserInfoException("不正确的邮箱格式");
		}
	}
}
