package com.Answer.CustomSimpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.Answer.Bean.Message;
import com.Answer.Database.DataBaseManager;
import com.Answer.Tools.Application;

public class MessageUser extends SimpleTagSupport {
	private String var;

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext p = ((PageContext) getJspContext());
		Message m = (Message) p.getAttribute(var);
		DataBaseManager manager = Application
				.getdatabaseManager(p.getSession());
		if (m.getUser_id() == 0) {
			p.getOut().write("匿名游客");
		} else
			p.getOut().write(manager.getUser(m.getUser_id()).getName());
	}

}
