package com.bolatu.util;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;

import com.bolatu.util.email.EmailConfig;
import com.bolatu.util.ftl.FtlService;

import freemarker.template.TemplateExceptionHandler;

@Configuration
@ComponentScan(basePackages = {"com.bolatu.util.ftl", "com.bolatu.util.email", "com.bolatu.util.fileupload"})
@PropertySource(value = "classpath:app-util-config.properties")
@EnableAsync
public class UtilityConfig {
	
	@Autowired
	private EmailConfig mailConfig;
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
	@Bean
	public JavaMailSender mailer() {
		
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.auth", mailConfig.isSmtpAuth());
		javaMailProperties.put("mail.smtp.starttls.enable", mailConfig.isStarttlsEnable());		
		javaMailProperties.put("mail.smtp.socketFactory.class", mailConfig.getSocketFactoryClass());
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(mailConfig.getSmtpHost());
		mailSender.setPort(mailConfig.getSmtpPort());		
		mailSender.setUsername(mailConfig.getSmtpUsername());
		mailSender.setPassword(mailConfig.getSmtpPassword());
		mailSender.setJavaMailProperties(javaMailProperties);
		
		return mailSender;
	}
	
	@PostConstruct
	private void init() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("i18n.service.messages", "i18n.client.messages");
		
		I18NUtil.setI18nSource(messageSource);
	}
	
	@Bean
	public freemarker.template.Configuration ftlConfig() {
		freemarker.template.Configuration cfg = new freemarker.template.Configuration(
				freemarker.template.Configuration.VERSION_2_3_22);
		cfg.setClassForTemplateLoading(FtlService.class, "../../../../mailTemplates");
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		
		return cfg;
	}

}
