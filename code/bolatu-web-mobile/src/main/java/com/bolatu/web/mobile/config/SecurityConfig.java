package com.bolatu.web.mobile.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.session.SessionManagementFilter;

import com.bolatu.util.HashingUtil;
import com.bolatu.web.mobile.service.AuthenticationService;
import com.bolatu.web.mobile.util.BolatuServiceRequestContextFilter;
import com.bolatu.web.mobile.util.jsf.JsfRedirectStrategy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationService authProvider;	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new BolatuServiceRequestContextFilter(), ChannelProcessingFilter.class);
		http.addFilterBefore(sessionManagementFilter(), SessionManagementFilter.class);
		
		http.authorizeRequests()
				.antMatchers("/assets/**").permitAll()
				.antMatchers("/javax.faces.resource/**").permitAll()				
				.antMatchers("/index.xhtml").permitAll()
				.antMatchers("/signup.xhtml").permitAll()
				.antMatchers("/confirmation.xhtml").permitAll()
				.antMatchers("/resetPassword.xhtml").permitAll()
				.antMatchers("/updatePassword.xhtml").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login.xhtml")
				.usernameParameter("main:username")
				.passwordParameter("main:password")
				.permitAll()
				.and()
				.logout().deleteCookies("remove")
				.invalidateHttpSession(true).logoutUrl("/logout.xhtml")
				.logoutSuccessUrl("/index.xhtml").permitAll();				
	}
	
	@Bean
	@Qualifier("passwordEncoder")
	public PasswordEncoder passwordEncoder() {
		return HashingUtil.getBCryptPasswordEncoder();
	}
	
	@Bean
	public SessionManagementFilter sessionManagementFilter() {
		SessionManagementFilter filter = new SessionManagementFilter(httpSessionSecurityContextRepository());
		filter.setInvalidSessionStrategy(jsfRedirectStrategy());
		return filter;
	}
	
	@Bean
	public JsfRedirectStrategy jsfRedirectStrategy() {
		JsfRedirectStrategy strategy = new JsfRedirectStrategy();
		strategy.setInvalidSessionUrl("/login.xhtml");		
		return strategy;
	}
	
	@Bean
	public HttpSessionSecurityContextRepository httpSessionSecurityContextRepository() {
		return new HttpSessionSecurityContextRepository();
	}
}
