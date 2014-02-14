package com.restjplat.quickweb.web.restServer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.restjplat.core.webserver.RestErrorCode;
import com.restjplat.core.webserver.RestServiceException;


@Controller
@RequestMapping(value="${websrverPath}")
public class RestUnmappingUri {
	
	@RequestMapping("/**")
    public void unmappedRequest(HttpServletRequest request) {
		 throw new RestServiceException("资源不存在 " + request.getRequestURI(),RestErrorCode.uri_not_found.getValue());
    }

}
