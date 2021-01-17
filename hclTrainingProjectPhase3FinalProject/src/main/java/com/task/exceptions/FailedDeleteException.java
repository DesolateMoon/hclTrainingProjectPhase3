package com.task.exceptions;


public class FailedDeleteException extends CustomException{
	public FailedDeleteException() {
		super();
	}

	public FailedDeleteException(String exceptionId) {
		super(exceptionId);
	}
}
