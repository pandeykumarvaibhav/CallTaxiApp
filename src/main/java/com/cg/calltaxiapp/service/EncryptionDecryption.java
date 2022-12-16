package com.cg.calltaxiapp.service;

public class EncryptionDecryption {

	public static String encryptPassword(String password) {
		String pwd = "";
	    for(int i=0 ;i<password.length() ; i++)
	    	pwd = pwd.concat(String.valueOf(password.charAt(i) + password.length()));
		return pwd;
	}
	
	public static String decryptPassword(String password) {
		String pwd = "";
	    for(int i=0 ;i<password.length() ; i++)
	    	pwd = pwd.concat(String.valueOf(password.charAt(i) - password.length()));
		return pwd;
	}
}
