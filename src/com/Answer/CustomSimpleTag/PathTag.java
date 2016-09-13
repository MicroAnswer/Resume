package com.Answer.CustomSimpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 显示服务器名的标签
 * @author Answer
 *
 */
public class PathTag extends SimpleTagSupport {
	private PageContext pc = null;
	@Override
	public void doTag() throws JspException, IOException {
		pc = (PageContext) getJspContext();
		String path = pc.getServletContext().getContextPath();
		pc.getOut().write(path);
	}

}
