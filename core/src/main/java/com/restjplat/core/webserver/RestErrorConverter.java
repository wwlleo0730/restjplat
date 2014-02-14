package com.restjplat.core.webserver;

public interface RestErrorConverter<T> {

	/**
	 * 将错误对象转化成map，用于页面的输出
	 * @return
	 */
	
	T convert(RestError re);
	
	/**
	 * 转化为json字串
	 * @param re
	 * @return
	 */
	String convertToJson(RestError re);
	
}
