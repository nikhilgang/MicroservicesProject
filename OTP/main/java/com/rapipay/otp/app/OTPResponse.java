package com.rapipay.otp.app;

public class OTPResponse {

    private String message;
    private boolean status;

    public OTPResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public OTPResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "OTPResponse [message=" + message + ", status=" + status + "]";
	}
    
}
