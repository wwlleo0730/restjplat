package com.restjplat.core.webserver;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
@Component
public class DefaultRestErrorResolver implements RestErrorResolver,InitializingBean{
	
	/**
	 * 预先定义的所有异常类型
	 */
	private Map<String, String> exceptionMappings = Collections.emptyMap();
	
	/**
	 * 配置文件中自定义扩展错误
	 */
	private Map<String, String> exceptionMappingDefinitions = Collections.emptyMap();
	

	@Override
	public RestError resolveError(HttpServletRequest request, Object handler,
			Exception ex) {
		RestError error = this.buildError(ex, request);		
		return error;
	}
	
	
	private RestError buildError(Exception ex, HttpServletRequest request) {
		RestError error = new RestError();
		error.setStatus(this.getHttpStatusByEx(ex));// 设置http状态
		
		//RestServiceException 包含有错误code
		if(ex instanceof RestServiceException){
			int errorCode = ((RestServiceException) ex).getErrorCode();
			error.setErrorCode(RestErrorCode.valueOf(errorCode));
		}
		else error.setErrorCode(RestErrorCode.valueOf(998));
		error.setMsg(ex.getMessage());
		if(null != request){
			error.setFromUri(request.getRequestURI());
		}else error.setFromUri("unknowurl");
		return error;
	}
	
	private HttpStatus getHttpStatusByEx(Exception ex){
		if(this.exceptionMappingDefinitions.containsKey(ex.getClass().getName())){
			return HttpStatus.valueOf(Integer.parseInt(this.exceptionMappingDefinitions.get(ex.getClass()
					.getName())));
		}
		else return HttpStatus.INTERNAL_SERVER_ERROR;
	}
	

	@Override
	public void afterPropertiesSet() throws Exception {
		//初始化所有预先定义的错误
		this.exceptionMappings = createDefaultExceptionMappingDefinitions();
		//如果存在自定义的错误,添加到预定义错误中
		if (this.exceptionMappingDefinitions != null && !this.exceptionMappingDefinitions.isEmpty()) {
			this.exceptionMappings.putAll(this.exceptionMappingDefinitions);
        }
		
	}
	
	/**
	 * 将spring中的http状态和异常互相对应 参考 spring的defaultExceptionHandler实现类似
	 * 
	 * @return
	 */
	private final Map<String, String> createDefaultExceptionMappingDefinitions() {

		Map<String, String> m = new LinkedHashMap<String, String>();

		// 400
		applyDef(m, HttpMessageNotReadableException.class,
				HttpStatus.BAD_REQUEST);
		applyDef(m, MissingServletRequestParameterException.class,
				HttpStatus.BAD_REQUEST);
		applyDef(m, TypeMismatchException.class, HttpStatus.BAD_REQUEST);
		applyDef(m, "javax.validation.ValidationException",
				HttpStatus.BAD_REQUEST);

		// 404
		applyDef(m, NoSuchRequestHandlingMethodException.class,
				HttpStatus.NOT_FOUND);
		applyDef(m, "org.hibernate.ObjectNotFoundException",
				HttpStatus.NOT_FOUND);
		
		// 405
		applyDef(m, HttpRequestMethodNotSupportedException.class,
				HttpStatus.METHOD_NOT_ALLOWED);

		// 406
		applyDef(m, HttpMediaTypeNotAcceptableException.class,
				HttpStatus.NOT_ACCEPTABLE);

		// 409
		applyDef(m, "org.springframework.dao.DataIntegrityViolationException",
				HttpStatus.CONFLICT);

		// 415
		applyDef(m, HttpMediaTypeNotSupportedException.class,
				HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		return m;
	}

	private void applyDef(Map<String, String> m, Class clazz, HttpStatus status) {
		applyDef(m, clazz.getName(), status);
	}

	private void applyDef(Map<String, String> m, String key, HttpStatus status) {
		m.put(key, status.value() + "");
	}


	public Map<String, String> getExceptionMappings() {
		return exceptionMappings;
	}


	public void setExceptionMappings(Map<String, String> exceptionMappings) {
		this.exceptionMappings = exceptionMappings;
	}


	public Map<String, String> getExceptionMappingDefinitions() {
		return exceptionMappingDefinitions;
	}


	public void setExceptionMappingDefinitions(
			Map<String, String> exceptionMappingDefinitions) {
		this.exceptionMappingDefinitions = exceptionMappingDefinitions;
	}
	
	
	
	
	
}
