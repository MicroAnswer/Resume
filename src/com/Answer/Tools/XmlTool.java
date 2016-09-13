package com.Answer.Tools;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.Answer.Bean.DatabaseConfig;

/**
 * 该类为解析XML文件类
 * @author Answer
 *
 */
public class XmlTool {
	private Document dom;
	private Element rooteElement;
	
	public XmlTool(File f){
		try{
			dom =  new SAXReader().read(f);
			rooteElement = dom.getRootElement();
		}catch(Exception a){
			a.printStackTrace();
		}
	}
	
	public Document getDom() {
		return dom;
	}

	public Element getRooteElement() {
		return rooteElement;
	}

	/**
	 * 获取配置
	 * @param id
	 * @return
	 */
	public DatabaseConfig getXmlConfig(int id){
		try{
		List<Element> nodes=rooteElement.selectNodes("//config[@id='"+id+"']");
			if(nodes.size() > 0 ){
				Element c = nodes.get(0);
				DatabaseConfig config = new DatabaseConfig();
				config.setId(id);
				config.setDatabaseDriver(c.element("databaseDriver").getText());
				config.setDatabaseName(c.element("databaseName").getText()); 
				config.setDatabasePort(Integer.parseInt(c.element("databasePort").getText()));
				config.setDatabaseUrl(c.element("databaseUrl").getText());
				config.setDatabaseUserName(c.element("databaseUserName").getText());
				config.setDatabaseUserPassword(c.element("databaseUserPassword").getText());
				return config;
			}else{
				return null;
			}
		}catch(Exception a){
			a.printStackTrace();
		}
		return null;
	}

}
