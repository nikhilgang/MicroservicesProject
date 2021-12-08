package com.rapipay.otp.app.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rapipay.otp.app.OTP;

@SpringBootTest
class OTPServiceTest {

	@Autowired
	private OTPService otpService;

	@Test
	@DisplayName("Validate Email 1")
	void testCheckEmail1() {
		//OTPService otpService = new OTPService();
		boolean expected = true;
		boolean actual = otpService.checkEmail("abc@gmail.com");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Validate Email 2")
	void testCheckEmail2() {
		//OTPService otpService = new OTPService();
		boolean expected = false;
		boolean actual = otpService.checkEmail("abc@gmail.");
		assertEquals(expected, actual);
	}

	@Test
	void testSendOTP() {
		OTP otp = new OTP(24, "email", "kk4112919@gmail.com", false);
		String actual = otpService.sendOTP(otp);
		String expected = "successfully";
		assertEquals(expected, actual);
	}

	@Test
	void testVerifyOTP() {

		OTP otp = new OTP("kk4112919@gmail.com", 132089, 0, false);

		assertThrows(Exception.class, () -> {
			otpService.verifyOTP(otp);
		});
	}

	@Test
	void testSendOTPSMS() {
		OTP otp = new OTP(24, "sms", "9197630200");

		String actual = otpService.sendOTPSMS(otp);
		String expected = "successfully";
		assertEquals(expected, actual);
	}
}