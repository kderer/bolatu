package com.bolatu.web.mobile.config;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.primefaces.webapp.filter.FileUploadFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.bolatu.rest.client.RestClientConfig;
import com.bolatu.util.UtilityConfig;
import com.sun.faces.config.ConfigureListener;

public class WebAppInitializer implements WebApplicationInitializer {
	
	@Override
	public void onStartup(ServletContext container) throws ServletException {
  		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
  		appContext.register(UtilityConfig.class);
  		appContext.register(RestClientConfig.class);  		 		
  		appContext.register(ApplicationConfig.class);
  		appContext.register(SecurityConfig.class);
  		
  		Dynamic facesServletReg = container.addServlet("Faces Servlet", FacesServlet.class);
  		facesServletReg.setLoadOnStartup(1);
  		
  		container.addFilter("PrimeFaces FileUpload Filter", FileUploadFilter.class).
  			addMappingForServletNames(null, false, "Faces Servlet");
  		
  		container.setInitParameter("com.sun.faces.forceLoadConfiguration", "true");
  		container.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
  		container.setInitParameter("javax.faces.CONFIG_FILES", "/WEB-INF/faces-config.xml");
  		container.setInitParameter("primefaces.UPLOADER", "native");
  		
  		container.addListener(new ContextLoaderListener(appContext));
  		container.addListener(new RequestContextListener());
  		container.addListener(ConfigureListener.class);  		
	}

}
