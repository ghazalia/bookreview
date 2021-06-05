package com.example.bookreview.exception;

public class DataAlreadyExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataAlreadyExistException() {
		super();
	}

	public DataAlreadyExistException(String cause) {
		super(cause);
	}
}
