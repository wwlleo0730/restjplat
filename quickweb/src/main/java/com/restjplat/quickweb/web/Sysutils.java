package com.restjplat.quickweb.web;

import com.restjplat.core.utils.PropertiesLoader;


/**
 * add 20140315
 * 
 * Creating a new branch is quick.
 * 
 * @author leos
 *
 */
public class Sysutils {
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader;
	
	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		if (propertiesLoader == null){
			propertiesLoader = new PropertiesLoader("resources.properties");
		}
		return propertiesLoader.getProperty(key);
	}
	
	public static String getWebServerindex() {
		return getConfig("websrverPath");
	}

}
