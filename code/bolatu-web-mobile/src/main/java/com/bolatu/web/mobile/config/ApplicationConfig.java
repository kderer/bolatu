package com.bolatu.web.mobile.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bolatu.web.mobile.util.SpringViewScope;

@Configuration
@ComponentScan(basePackages = {"com.bolatu.web.mobile.managed", "com.bolatu.web.mobile.service"})
public class ApplicationConfig {
	
	@Bean
	public static BeanFactoryPostProcessor viewScopeProcessor() {
		return new BeanFactoryPostProcessor() {
			
			@Override
			public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
				beanFactory.registerScope("view", new SpringViewScope());
			}
		};
	}

}
