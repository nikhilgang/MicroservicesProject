package com.transaction.entity;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "otp")
public class OTP {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer userId;
	private String channelName;
	private Integer orderId;
	@Nullable
	private String email;
	@Nullable
	private String phoneNo;
	private Integer otp;
	private boolean verified;
	private long created_at;

	public OTP() {
	}

	public OTP(String email, Integer otp, long created_at, boolean verified) {
		this.email = email;
		this.orderId = 1000 + new Random().nextInt(9000);
		this.otp = otp;
		this.verified = verified;
		this.created_at = created_at;
	}

	public String getChannelName() {
		return channelName;
	}

	public OTP(Integer userId, String channelName, String email, boolean verified) {
		super();
		this.userId = userId;
		this.channelName = channelName;
		this.email = email;
		this.verified = verified;
	}

	public OTP(Integer userId, String channelName, String email) {
		super();
		this.userId = userId;
		this.channelName = channelName;
		this.email = email;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId() {
		this.orderId = 1000 + new Random().nextInt(9000);
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
		return "OTP [userId=" + userId + ", channelName=" + channelName + ", orderId=" + orderId + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", otp=" + otp + ", verified=" + verified + ", created_at=" + created_at
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channelName == null) ? 0 : channelName.hashCode());
		result = prime * result + (int) (created_at ^ (created_at >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((otp == null) ? 0 : otp.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + (verified ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OTP other = (OTP) obj;
		if (channelName == null) {
			if (other.channelName != null)
				return false;
		} else if (!channelName.equals(other.channelName))
			return false;
		if (created_at != other.created_at)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (otp == null) {
			if (other.otp != null)
				return false;
		} else if (!otp.equals(other.otp))
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (verified != other.verified)
			return false;
		return true;
	}

}
