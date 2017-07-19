package com.snoopconsulting.antecedentes.crm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class SugarCredentials {

	private String user_name;
	private String password;

	public SugarCredentials() throws NoSuchAlgorithmException {
		this(null, null);
	}

	public SugarCredentials(String userId, String plaintextPassword) throws NoSuchAlgorithmException {
		this.user_name = userId;
		if (plaintextPassword != null) {
			setPassword(plaintextPassword);
		}
	}

	public void setPassword(String plaintextPassword) throws NoSuchAlgorithmException {

		this.password = Hex.encodeHexString(MessageDigest.getInstance("MD5")
				.digest(plaintextPassword.getBytes()));

	}

	public String getUserName() {
		return user_name;
	}

	public String getEncodedPassword() {
		return password;
	}

}