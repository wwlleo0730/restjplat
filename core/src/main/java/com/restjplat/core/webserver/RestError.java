package com.restjplat.core.webserver;

import org.springframework.http.HttpStatus;

/**
 * 用于构建web服务的错误对象
 * @author leos
 *
 */
public class RestError {
	
	/**
	 * http状态码
	 */
	private HttpStatus status;
	/**
	 * 错误码
	 */
	private RestErrorCode errorCode;
    /**
     * 错误信息
     */
	private String msg;
	/**
	 * 请求来源
	 */
	private String fromUri;
	
	public RestError(){
		
	}

	public RestError(HttpStatus status, RestErrorCode errorCode, String msg,String fromUri) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.msg = msg;
		this.fromUri = fromUri;
	}

	public HttpStatus getStatus() {
		return status;
	}


	public RestErrorCode getErrorCode() {
		return errorCode;
	}


	public String getMsg() {
		return msg;
	}


	public String getFromUri() {
		return fromUri;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public void setErrorCode(RestErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setFromUri(String fromUri) {
		this.fromUri = fromUri;
	}
	
    public String toString() {
        return new StringBuilder().append("HttpStatus:").append(getStatus().value())
                .append(" errorcode:")
                .append(this.getErrorCode().getValue())
                .append(" errorReason:")
                .append(this.getErrorCode().getErrorReason())
                .append(" errorMsg:")
                .append(this.getMsg())
                .append(" errorURL").append(this.getFromUri())
                .toString();
    }
}
