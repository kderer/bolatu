package com.bolatu.rest.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.bolatu.db.impl.DatabaseConfig;
import com.bolatu.service.impl.ServiceConfig;
import com.bolatu.util.UtilityConfig;
;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(UtilityConfig.class);
  		appContext.register(DatabaseConfig.class);
  		appContext.register(ServiceConfig.class);  		
  		appContext.register(ApplicationConfig.class);
		appContext.setServletContext(container);

		Dynamic servlet = container.addServlet("dispatcher",
				new DispatcherServlet(appContext));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
