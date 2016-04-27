package com.company.auth.client.exception;

public class DuplicateResourceException extends Exception {

	
	private static final long serialVersionUID = 1L;

    public DuplicateResourceException() {}

    public DuplicateResourceException(String message) {
            super(message);
    }

    public DuplicateResourceException(String message, Throwable cause) {
            super(message, cause);
    }
}
	
