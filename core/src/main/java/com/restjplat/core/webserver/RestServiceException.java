package com.restjplat.core.webserver;

public class RestServiceException extends RuntimeException{
	
	private int errorCode;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4854901217206974677L;
	

	public RestServiceException(){
	}
	
	
	public RestServiceException(String message) {  
        super(message);
        this.errorCode = 998; //未知错误
    }


	public RestServiceException(String message,int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	

}
