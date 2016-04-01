package com.leclex.spring.ch5.mvc.exception;

public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String exceptionMsg;
	private String exceptionCode;
	
	public GenericException(String exceptionMsg, String exceptionCode) {
		this.exceptionMsg = exceptionMsg;
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
}
