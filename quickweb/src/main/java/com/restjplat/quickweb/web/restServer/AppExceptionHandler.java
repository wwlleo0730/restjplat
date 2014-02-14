package com.restjplat.quickweb.web.restServer;

import javax.servlet.http.HttpServletRequest;

import com.restjplat.core.webserver.RestServiceExceptionHandler;
import com.restjplat.quickweb.web.Sysutils;

public class AppExceptionHandler extends RestServiceExceptionHandler{
	
	@Override
	public boolean isRestServiceException(HttpServletRequest request){
		if(request.getServletPath().startsWith(Sysutils.getWebServerindex())) return true;
		else return false;
	}

}
