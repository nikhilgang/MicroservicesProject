package com.rapipay.otp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rapipay.otp.app.OTP;
import com.rapipay.otp.app.Services.OTPService;

@RestController
@RequestMapping("/api/v1")
public class OTPController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OTPController.class);

	@Autowired
	OTPService otpService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "OTP api up and running";
	}

	public boolean verifyEmail(String email) {
		boolean isValid=false;
		
 		return isValid;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/generateOTP")
	public String sendOTP(@RequestBody OTP otp) {
		LOGGER.info("Inside sendOTP controller");
		System.out.println("Inside Email");
		try {
			if(otp.getChannelName().equals("email")) {
				System.out.println("------------------");
				otpService.sendOTP(otp);
				
			}else {
				System.out.println("************");
				otpService.sendOTPSMS(otp);
			}
				
			
		}catch(Exception e){
			return e.toString();
		}
		
		return "OTP sent successfully";
	}
	

	@RequestMapping(method = RequestMethod.POST, value = "/verifyOTP")
	public String verifyOTP(@RequestBody OTP otp){
		LOGGER.info("Inside verifyOTP controller");
		try {
			return otpService.verifyOTP(otp);
		}catch(Exception e) {
			return e.toString();
		}
		
	}

}
