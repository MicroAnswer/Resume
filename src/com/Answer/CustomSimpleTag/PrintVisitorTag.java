package com.Answer.CustomSimpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**
 * 自定义输出IP地址标签
 * 同时，将Ip保存到session里面
 * @author Answer
 * 
 */
public class PrintVisitorTag extends SimpleTagSupport {
	private JspContext Jc = null;
	/**
	 * 覆盖了父类的DoTag方法，在系统执行到该标签的时候会调用该方法
	 */
	@Override
	public void doTag() throws JspException, IOException {
		Jc = getJspContext();
		PageContext pc = (PageContext) Jc;
		String ip = pc.getRequest().getRemoteAddr();
		Jc.getOut().write("游客");
		pc.getSession().setAttribute("ip", ip);
	}

}
