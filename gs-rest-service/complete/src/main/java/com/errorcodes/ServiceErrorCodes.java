package com.errorcodes;

public enum ServiceErrorCodes {
	
	INVALID_SERVICE_DESCRIPTION("9001", "Invalid Service Description");
	
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
