package com.rapipay.otp.exception;

public class InvalidAttemptsException extends RuntimeException {
	private String message;

	public InvalidAttemptsException() {
		super();
	}

	public InvalidAttemptsException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidAttemptsException [message=" + message + "]";
	}
	
	

}
