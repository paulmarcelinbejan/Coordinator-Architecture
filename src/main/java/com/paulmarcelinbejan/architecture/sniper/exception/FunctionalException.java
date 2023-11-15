package com.paulmarcelinbejan.architecture.sniper.exception;

public class FunctionalException extends Exception {
	
	private static final long serialVersionUID = 282018305935754409L;

	public FunctionalException(String message) {
		super(message);
	}

	public FunctionalException(String message, Throwable cause) {
		super(message, cause);
	}

	public FunctionalException(Throwable cause) {
		super(cause);
	}

}