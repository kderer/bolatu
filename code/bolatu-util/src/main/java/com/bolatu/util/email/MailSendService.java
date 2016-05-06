package com.bolatu.util.email;

import java.io.File;

import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.bolatu.util.LogUtil;
import com.bolatu.util.ftl.FtlService;

@Service
public class MailSendService {

	@Autowired
	private JavaMailSender mailer;
	
	@Autowired
	private FtlService ftlService;
	
	@Async
	public void sendMail(Email email) {
		sendMail(email, false);
	}
	
	public void sendMailWithTemplate(EmailWithTemplate emailWithTemplate) {
		try {
			Email email = new Email();
			email.setFrom(emailWithTemplate.getFrom());
			email.setCcList(emailWithTemplate.getCcList());
			email.setToList(emailWithTemplate.getToList());
			email.setSubject(emailWithTemplate.getSubject());
			email.setBody(ftlService.mailTemplateOutput(emailWithTemplate));
			email.setAttachmentList(emailWithTemplate.getAttachmentList());
			
			sendMail(email, emailWithTemplate.getTemplate().isHtml());			
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.UTILLOGGER, e);
		}
	}
	
	private void sendMail(Email email, boolean isHtml) {
		try {
			MimeMessage msg = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setFrom(email.getFrom());
			helper.setTo(email.getToListArray());			
			helper.setSubject(email.getSubject());
			
			if (isHtml) {
				helper.setText("", email.getBody());
			} else {
				helper.setText(email.getBody());
			}
			
			if (email.getAttachmentList() != null) {
				for (File attachment : email.getAttachmentList()) {
					helper.addAttachment(attachment.getName(), new FileDataSource(attachment));
				}
			}

			mailer.send(msg);

			LogUtil.UTILLOGGER.info("Email [{}] is sent to {}.",
					email.getSubject(), email.getToList().toString());
		} catch (Exception e) {
			LogUtil.UTILLOGGER.error("{} while sending email to {}.", e.getClass(), email
					.getToList().toString());
		}
	}
}
