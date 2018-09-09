package com.cftechsol.rest.exceptions;

public enum CFMessages {
	
	// Generic Messages 00000 - 09999
	NOT_FOUND("Not found", "45001"),
	MISSING_ARGUMENTS("Missing arguments", "45002"),
	// API: cf-security-api | 05000 - 05999
	USER_NOT_FOUND("User not found", "05000"),
	CURRENT_PASSWORD_IS_WRONG("User not found", "05001"),
	// Generic messages 90000 - 99999
	ERROR("An error ocurred", "99999")
	;
	
	private String message;
	private String messageRef;
	
	CFMessages(String message, String messageRef) {
		this.message = message;
		this.messageRef = "CF-" + messageRef;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getMessageRef() {
		return messageRef;
	}
	
}
