package com.Answer.Bean;

import java.util.ArrayList;

/***
 * 一个留言页面
 * 
 * @author wwwfa
 * 
 */
public class MessagePage implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2449638157957504518L;
	private int nextpage;
	private int uppage;
	private int firstpage;
	private int lastpage;
	private int nowpage;
	private int messagecount;
	public int getMessagecount() {
		return messagecount;
	}
	public void setMessagecount(int messagecount) {
		this.messagecount = messagecount;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getFirstpage() {
		return firstpage;
	}
	public void setFirstpage(int firstpage) {
		this.firstpage = firstpage;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private ArrayList<Message> list;
	private int allpage;
	public int getNextpage() {
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		if(nextpage>allpage){
			nextpage = allpage;
			return;
		}
		this.nextpage = nextpage;
	}
	public int getUppage() {
		return uppage;
	}
	public void setUppage(int uppage) {
		if(uppage<=0){
			this.uppage=1;
			return;
		}
		this.uppage = uppage;
	}
	public ArrayList<Message> getList() {
		return list;
	}
	public void setList(ArrayList<Message> list) {
		this.list = list;
	}
	public int getAllpage() {
		return allpage;
	}
	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}

}
