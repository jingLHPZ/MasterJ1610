package com.sxt.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import com.sxt.service.Base64Encrypt;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@Service
public class Base64EncryptImpl implements Base64Encrypt {

	@Override
	public String encrypt(String password) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes());
			password = Base64.encode(messageDigest.digest());
			System.out.println(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return password;
	}

}
