package com.bolatu.service.impl.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bolatu.db.impl.test.DatabaseTestConfig;
import com.bolatu.service.api.request.ServiceRequestInfo;
import com.bolatu.service.impl.ServiceConfig;
import com.bolatu.service.impl.request.ServiceRequestInfoImpl;
import com.bolatu.util.UtilityConfig;
import com.bolatu.util.enumaration.BolatuSite;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UtilityConfig.class, DatabaseTestConfig.class, ServiceConfig.class})
public abstract class BaseTestConfig {
	
	protected ServiceRequestInfo getDefaultServiceRequestInfo() {
		ServiceRequestInfo info = new ServiceRequestInfoImpl();
		info.setIp("127.0.0.1");
		info.setLanguage("en");
		info.setSite(BolatuSite.MOBILE.getSiteCode());
		info.setTimeZone("GMT+8");
		info.setUsername("abaza31");
		
		return info;
	}

}
