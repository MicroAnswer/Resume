package com.Answer.CustomSimpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.Answer.Database.DataBaseManager;

/**
 * 显示已注册人数
 * 
 * @author Answer
 * 
 */
public class ShowAlluserTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext) getJspContext();
		DataBaseManager manager = (DataBaseManager) pc.getSession()
				.getAttribute("databaseManager");
		if (manager == null) {
			manager = new DataBaseManager(getClass().getCanonicalName());
			pc.getSession().setAttribute("databaseManager", manager);
		}
		pc.getOut().write(manager.getAllUserCount() + "");
	}

}
