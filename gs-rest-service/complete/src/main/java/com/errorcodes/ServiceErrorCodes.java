package com.errorcodes;

public enum ServiceErrorCodes {
	
	INVALID_MESSAGE("9001", "Invalid Message"),
	EMPTY_DATASET("9002", "No Message data found"),
	EMPTY_USERSET("9003", "No user data found"),
	INVALID_USERNAME("9004", "Invalid user name");
	
	private final String value;
	
	private final String reasonPhrase;
	
	private ServiceErrorCodes(String value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}
    /**
     * Return the string value of this status code
     * @return
     */
	public String getValue() {
		return value;
	}
	/**
	 * Return the reason phrase of this status code
	 * @return
	 */
	public String getReasonPhrase() {
		return reasonPhrase;
	}
	
	public static ServiceErrorCodes fromString(String text) {
		for(ServiceErrorCodes code: ServiceErrorCodes.values()) {
			if(code.value.equals(text)) {
				return code;
			}
		}
		return null;
	}

}
