package com.cftechsol.rest.exceptions;

import lombok.Getter;

/**
 * Non unique exception.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
public class BadRequestException extends Exception {

	private static final long serialVersionUID = 8913908467686536761L;
	
	private String messageRef;

	public BadRequestException(String message) {
		super(message);
	}
	
	public BadRequestException(String message, String messageRef) {
		super(message);
		this.messageRef = messageRef;
	}

}
