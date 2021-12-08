package com.rapipay.otp.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OTPRepository extends JpaRepository<OTP, Integer> {

    List<OTP> findByEmailAndOtpAndVerified(String email, Integer otp,boolean verified);
    List<OTP> findByEmailAndVerified(String email,boolean verified);
    List<OTP> findByPhoneNoAndVerified(Long phoneNo,boolean verified);
}