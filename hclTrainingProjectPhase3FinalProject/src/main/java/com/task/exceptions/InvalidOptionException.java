package com.task.exceptions;

public class InvalidOptionException extends CustomException{
	public InvalidOptionException() {
		super();
	}

	public InvalidOptionException(String exceptionId) {
		super(exceptionId);
	}
}
