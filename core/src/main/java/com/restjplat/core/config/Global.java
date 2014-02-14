/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.restjplat.core.config;

import com.restjplat.core.utils.PropertiesLoader;



/**
 * 全局配置类
 * @author leos
 * @version 2013-03-23
 */
public class Global {
	
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

	/////////////////////////////////////////////////////////
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	public static String getFrontPath() {
		return getConfig("frontPath");
	}
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}
	
}
