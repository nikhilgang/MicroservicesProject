package com.rapipay.otp.app;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="otp")
public class OTP {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    private String email;
    private Integer otp;
    private boolean verified;
    private long created_at;

    public OTP() {
    }

    public OTP(String email, Integer otp, long created_at,boolean verified) {
        this.email = email;
        this.otp = otp;
        this.verified = verified;
        this.created_at = created_at;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "OTP{" +
                "email='" + email + '\'' +
                ", otp=" + otp +
                ", created_at=" + created_at +
                '}';
    }


    
}
