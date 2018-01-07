package com.ts.urbanspoon.exception;

public class UrbanspoonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public UrbanspoonException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UrbanspoonException [message=" + message + "]";
	}

}
