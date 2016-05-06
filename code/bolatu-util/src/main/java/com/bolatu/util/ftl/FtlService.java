package com.bolatu.util.ftl;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bolatu.util.LogUtil;
import com.bolatu.util.email.EmailWithTemplate;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class FtlService {
	
	@Value("${ftl.config.assets.url}")
	private String assetsUrl;
	
	@Value("${ftl.config.sitename}")
	private String sitename;
	
	@Value("${ftl.config.signup.confirmation.url}")
	private String signupConfirmationUrl;
	
	@Value("${ftl.config.password.update.url}")
	private String resetPasswordUrl;	
	
	@Autowired
	private Configuration ftlConfig;
	
	private Map<String, Object> ftlConfigMap;
	
	public String mailTemplateOutput(EmailWithTemplate email) {
		return templateOutput(email.getTemplate().getFileName(), email.getDataMap());
	}
	
	public String templateOutput(String templateFile, Map<String, Object> dataMap) {
		String output = "";
		
		try {
			Template temp = ftlConfig.getTemplate(templateFile);
			StringWriter writer = new StringWriter();			
			putFtlConfig(dataMap);
			temp.process(dataMap, writer);
			output = writer.toString();
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.UTILLOGGER, e);
		}
		
		return output;
	}
	
	public void putFtlConfig(Map<String, Object> dataMap) {
		dataMap.put("ftlConfig", ftlConfigMap);
	}
	
	public void putFtlConfig(Map<String, Object> dataMap, String mapKey) {
		dataMap.put(mapKey, ftlConfigMap);
	}
	
	@PostConstruct
	private void init() {
		ftlConfigMap = new HashMap<String, Object>();		
		ftlConfigMap.put("assetUrl", assetsUrl);
		ftlConfigMap.put("signupConfirmationUrl", signupConfirmationUrl);
		ftlConfigMap.put("sitename", sitename);
		ftlConfigMap.put("resetPasswordUrl", resetPasswordUrl);
	}
}
