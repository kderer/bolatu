package com.bolatu.rest.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.bolatu.rest.web.controller"})
@EnableWebMvc
public class ApplicationConfig {
	
}
