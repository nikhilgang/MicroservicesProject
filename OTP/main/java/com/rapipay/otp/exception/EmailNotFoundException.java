package com.rapipay.otp.exception;


public class EmailNotFoundException extends RuntimeException {

	private String message;
	

    public EmailNotFoundException() {
		super();
	}


	public EmailNotFoundException(String message) {
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
		return "EmailNotFoundException [message=" + message + "]";
	}


	
    
}
