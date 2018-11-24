package com.exception;

/**
 * @author sowjhanyaashok
 *
 */
public class ApplicationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String userMessage;
	
	public ApplicationException() {
		super();
	}	

	public ApplicationException(String errorCode, String userMessage) {
		super();
		this.setErrorCode(errorCode);
		this.setUserMessage(userMessage);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
}
