package com.Answer.Bean;

import java.io.Serializable;

/**
 * 数据库配置JavaBean
 * 
 * @author Answer
 * 
 */
public class DatabaseConfig implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String databaseName;
	private String databaseUserName;
	private String databaseUserPassword;
	private String databaseUrl;
	private int databasePort;
	private String databaseDriver;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDatabaseUserName() {
		return databaseUserName;
	}

	public void setDatabaseUserName(String databaseUserName) {
		this.databaseUserName = databaseUserName;
	}

	public String getDatabaseUserPassword() {
		return databaseUserPassword;
	}

	public void setDatabaseUserPassword(String databaseUserPassword) {
		this.databaseUserPassword = databaseUserPassword;
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public void setDatabaseUrl(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

	public int getDatabasePort() {
		return databasePort;
	}

	public void setDatabasePort(int databasePort) {
		this.databasePort = databasePort;
	}

	public String getDatabaseDriver() {
		return databaseDriver;
	}

	public void setDatabaseDriver(String databaseDriver) {
		this.databaseDriver = databaseDriver;
	}

	@Override
	public String toString() {
		return id+":"+this.databaseName + "-" + this.databaseUserName + "-"
				+ databaseUserPassword + "-" + databaseDriver + "-"
				+ databasePort + "-" + databaseUrl;
	}

}
