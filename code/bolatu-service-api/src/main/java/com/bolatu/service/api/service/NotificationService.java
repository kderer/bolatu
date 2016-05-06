package com.bolatu.service.api.service;

import java.util.Date;

import com.bolatu.db.api.model.Message;
import com.bolatu.db.api.model.ResetPasswordCode;
import com.bolatu.db.api.model.SignupConfirmation;

public interface NotificationService {
	
	public void sendConfirmation(SignupConfirmation confirmation);
	
	public void sendMessageNotification(Message message);
	
	public void sendResetPasswordCode(ResetPasswordCode resetPasswordCode);
	
	public void sentUpdatePasswordResult(String email, String ip, Date time);

}
