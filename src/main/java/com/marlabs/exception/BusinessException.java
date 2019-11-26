package com.marlabs.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BusinessException extends Exception {

	private static final long serialVersionUID = -3255537269611230349L;

	private Throwable cause;

	private String errorCode;

	private String errorMsg;

	public BusinessException(String errorCode, String errorMsg, Throwable cause) {
		this.cause = cause;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public BusinessException(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public BusinessException(Throwable cause) {

		this.cause = cause;
	}

}
