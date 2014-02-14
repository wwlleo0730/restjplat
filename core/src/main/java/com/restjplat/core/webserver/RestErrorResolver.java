package com.restjplat.core.webserver;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常和错误对象的转换接口
 * @author leos
 *
 */
public interface RestErrorResolver {
	
	
	/**
	 * 
	 * @param request 请求
	 * @param handler 处理方法
	 * @param ex 异常
	 * @return
	 */
	RestError resolveError(HttpServletRequest request, Object handler, Exception ex);
	
}
