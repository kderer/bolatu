package com.bolatu.util.constant;

public interface BolatuServiceReturnCodes {
	
	public static final String SUCCESS = "000000";
	public static final String REST_ERROR = "000001";
	public static final String JSON_EXCEPTION = "000002";
	
	public static final String USERNAME_OR_PASSWORD_WRONG = "100000";
	public static final String USER_ALREADY_EXIST = "100001";
	public static final String USER_DOES_NOT_EXIST = "100002";
	public static final String USER_STATUS_NOT_VALID = "100003";
	
	public static final String CONFIRMATION_REQUEST_NOT_FOUND = "100200";
	
	public static final String RESET_PASSWORD_REQUEST_NOT_FOUND = "100300";
	
	public static final String USER_AUTHINFO_NOT_FOUND = "100400";
	public static final String USER_AUTHINFO_UPDATE_EXCEPTION = "100401";
	
	public static final String ENTRY_NOT_FOUND = "300001";
	
	public static final String DAO_SUCCESS = "200000";
	public static final String DAO_NULL = "200001";
	

}
