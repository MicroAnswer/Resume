package com.Answer.CustomSimpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 这个标签类用于在页面输出一个大的圆角矩形
 * 
 * @author Answer
 * 
 */
public class MainBoxTag extends SimpleTagSupport {
	private int width = 800;
	private int height = 1000;
	private int radius = 15;
	private String borderColor = "#000000";
	private String bgColor = "#555555";
	private String topbg = "#123456";
	private String margin = "12px auto 0px auto";
	private int boderSize = 2;
	private String mCustomStyle = "";
	public void setMargin(String margin) {
		this.margin = margin;
	}

	public void setBoderSize(int boderSize) {
		this.boderSize = boderSize;
	}

	@Override
	public void doTag() throws JspException, IOException {
		getJspContext()
				.getOut()
				.write("<div style='width: "
						+ width
						+ "px; height:"
						+ height
						+ "px; border-radius:"
						+ radius
						+ "px; border: "
						+ borderColor
						+ " "
						+ boderSize
						+ "px solid; background: "
						+ bgColor
						+ "; margin: "
						+ margin
						+ ";"+mCustomStyle+";'>"
						+ "<div style='height:30px; width:100%; background: "+topbg+"; border-radius:"+radius+"px "+radius+"px 0px 0px; margin: -2px; border: 2px "+topbg+" solid;'> <img alt='#' src='bg/logo_answer.png' style='margin-left: 24px; float:left; Color:#000000; line-height: 30px;'></div>");
		getJspBody().invoke(null);
		getJspContext().getOut().write("</div>");
	}




	public void setmCustomStyle(String mCustomStyle) {
		this.mCustomStyle = mCustomStyle;
	}

	public void setTopbg(String topbg) {
		this.topbg = topbg;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
}
