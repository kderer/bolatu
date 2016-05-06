package com.bolatu.service.impl.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolatu.db.api.dao.UserDao;
import com.bolatu.db.api.model.Message;
import com.bolatu.db.api.model.ResetPasswordCode;
import com.bolatu.db.api.model.SignupConfirmation;
import com.bolatu.service.api.service.NotificationService;
import com.bolatu.util.DateUtil;
import com.bolatu.util.LogUtil;
import com.bolatu.util.email.Email;
import com.bolatu.util.email.EmailWithTemplate;
import com.bolatu.util.email.MailSendService;
import com.bolatu.util.enumaration.MailTemplate;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MailSendService mailSendService;
	
	@Override
	public void sendConfirmation(SignupConfirmation confirmation) {	
		StringBuilder confirmationParameters = new StringBuilder("username=");
		confirmationParameters.append(confirmation.getUsername());
		confirmationParameters.append("&hash=");
		confirmationParameters.append(confirmation.getConfirmationCode());
		
		EmailWithTemplate email = new EmailWithTemplate();
		email.addToToList(confirmation.getEmail());
		email.setSubject("Bolatu Confirmation");
		email.setTemplate(MailTemplate.SIGNUP);
		email.setFrom("noreply@imbolatu.com");
		email.getDataMap().put("username", confirmation.getUsername());		
		email.getDataMap().put("signupConfirmationParameters", confirmationParameters.toString());
		
		mailSendService.sendMailWithTemplate(email);		
	}

	@Override
	public void sendMessageNotification(Message message) {
		try {
			Email email = new Email();
			email.addToToList(userDao.findMessageReceiver(message).getEmail());
			email.setSubject("You have a new message");
			email.setBody(message.getSender() + " has sent you a message! Please login to check");
			email.setFrom("noreply@imbolatu.com");
			
			mailSendService.sendMail(email);
		} catch (Exception ex) {
			LogUtil.printExceptionLog(LogUtil.SERVICELOGGER, ex);
		}
	}

	@Override
	public void sendResetPasswordCode(ResetPasswordCode resetPasswordCode) {
		StringBuilder resetPasswordParameters = new StringBuilder("address=");
		resetPasswordParameters.append(resetPasswordCode.getEmail());
		resetPasswordParameters.append("&uuid=");
		resetPasswordParameters.append(resetPasswordCode.getCode());
		
		EmailWithTemplate email = new EmailWithTemplate();
		email.addToToList(resetPasswordCode.getEmail());
		email.setSubject("Bolatu Reset Password");
		email.setTemplate(MailTemplate.RESET_PASSWORD);
		email.setFrom("password@imbolatu.com");		
		email.getDataMap().put("resetPasswordParameters", resetPasswordParameters.toString());
		
		mailSendService.sendMailWithTemplate(email);
		
	}

	@Override
	public void sentUpdatePasswordResult(String email, String ip, Date time) {
		EmailWithTemplate emailWithTemp = new EmailWithTemplate();
		emailWithTemp.addToToList(email);
		emailWithTemp.setSubject("Bolatu Update Password");
		emailWithTemp.setTemplate(MailTemplate.UPDATE_PASSWORD);
		emailWithTemp.setFrom("password@imbolatu.com");		
		emailWithTemp.getDataMap().put("updateTime", DateUtil.convertToChinaDateString(time));
		emailWithTemp.getDataMap().put("updateIp", ip);
		
		mailSendService.sendMailWithTemplate(emailWithTemp);		
	}

}
