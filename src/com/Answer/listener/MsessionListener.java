package com.Answer.listener;

import java.util.HashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.Answer.Tools.Application;
import com.Answer.Tools.Application.U;

/**
 * Application Lifecycle Listener implementation class MsessionListener
 *
 */
@WebListener
public class MsessionListener implements HttpSessionListener {

  


    public void sessionCreated(HttpSessionEvent se)  { 
    	
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession session = se.getSession();
    	
    	U u = (U) session.getAttribute("chart");
    
    	if(null != u){
    		HashMap<String,U> allChartU = Application.getAllChartU();
    		
    		if(allChartU.containsKey(u.name)){
    			U u2 = allChartU.remove(u.name);
    			System.out.println(u2.name+"退出成功");
    		}
    		
    	}
    	
    	
    	
    }
	
}
