package com.Answer.CustomSimpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShowTimeTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().write("<span id='zsefbghujm'></span>	<script type='text/javascript'>	function refreshDate(){			var date = new Date();			var htmltime=document.getElementById('zsefbghujm');			htmltime.innerHTML = (date.getHours()+':'+date.getMinutes()+':'+date.getSeconds());		}		setInterval('refreshDate()', '1000');	</script>");
	}

}
