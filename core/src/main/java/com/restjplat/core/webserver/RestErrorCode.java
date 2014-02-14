package com.restjplat.core.webserver;

/**
 * 暂时放几个错误代码，以后添加
 * @author leos
 *
 */
public enum RestErrorCode {
	
	/**
	 * 未知错误
	 */
	unknow_error (998, "unknow_error"),
	
	/**
	 * 需要权限
	 */
	need_permission (1000 ,"need_permission"),
	
	/**
	 * 资源不存在
	 */
	uri_not_found (1001,"uri_not_found"),
	
	/**
	 * 参数不全
	 */
	missing_args (1002,"missing_args");
	
	private final int value; //错误码
	private final String errorReason; //错误原因
	
	public int getValue() {
		return value;
	}

	public String getErrorReason() {
		return errorReason;
	}


	private RestErrorCode(int value, String errorReason) {
		this.value = value;
		this.errorReason = errorReason;
	}
	
	
	public static RestErrorCode valueOf(int errorCode) {
		for (RestErrorCode status : values()) {
			if (status.value == errorCode) {
				return status;
			}
		}
		throw new IllegalArgumentException("No matching constant for [" + errorCode + "]");
	}

}
