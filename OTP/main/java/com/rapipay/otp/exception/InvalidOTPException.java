package com.rapipay.otp.exception;

public class InvalidOTPException extends RuntimeException {
	private String message;

	public InvalidOTPException() {
		super();
	}

	public InvalidOTPException(String message) {
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
		return "InvalidOTPException [message=" + message + "]";
	}
	

}
