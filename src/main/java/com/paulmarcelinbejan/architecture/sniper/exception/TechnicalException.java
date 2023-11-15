package com.paulmarcelinbejan.architecture.sniper.exception;

public class TechnicalException extends Exception {

	private static final long serialVersionUID = -5796404131081707392L;

	public TechnicalException(String message) {
		super(message);
	}

	public TechnicalException(String message, Throwable cause) {
		super(message, cause);
	}

	public TechnicalException(Throwable cause) {
		super(cause);
	}

}