package com.rapipay.otp.exception;

public class InvalidEmailException extends RuntimeException {
	private String message;

	public InvalidEmailException(String message) {
		super();
		this.message = message;
	}

	public InvalidEmailException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidEmailException [message=" + message + "]";
	}
	
	

}
