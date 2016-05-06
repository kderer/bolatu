package com.bolatu.db.impl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bolatu.db.api.model.ResetPasswordCode;

@Document(collection = "resetPasswordCode")
public class ResetPasswordCodeImpl implements ResetPasswordCode {
	
	@Id
	private String email;
	private String code;
	private long createTime;
	private String requestIp;
	private char type;
	
	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getCode() {
		return code;
	}
	
	@Override
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public long getCreateTime() {
		return createTime;
	}
	
	@Override
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String getRequestIp() {
		return requestIp;
	}
	
	@Override
	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}
	
	@Override
	public char getType() {
		return type;
	}

	@Override
	public void setType(char type) {
		this.type = type;
	}
	
	public static enum ResetPasswordCodeField {		
		email("email"),
		code("code"),
		createTime("createTime"),
		ip("ip"),
		type("type"),
		collection("resetPasswordCode");
		
		private final String field;
		
		private ResetPasswordCodeField(String field){
			this.field = field;
		}
		
		public String getField(){
			return field;
		}		
	}
	
}
