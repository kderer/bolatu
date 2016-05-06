package com.bolatu.db.api;

import com.bolatu.util.constant.BolatuDbExceptionCodes;

public class BolatuDbException extends Exception implements BolatuDbExceptionCodes {

	private static final long serialVersionUID = 5728767277278152822L;
	
	private String dbExceptionCode;
	
	public BolatuDbException(String dbExceptionCode) {
		this.dbExceptionCode = dbExceptionCode;
	}

	public String getDbExceptionCode() {
		return dbExceptionCode;
	}

	public void setDbExceptionCode(String dbExceptionCode) {
		this.dbExceptionCode = dbExceptionCode;
	}

}
