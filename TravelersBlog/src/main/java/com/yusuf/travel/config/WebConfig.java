package com.yusuf.travel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer{
	/*
	 * @Autowired private MessageSource messageSource;
	 * 
	 * @Override public void addViewControllers(ViewControllerRegistry registry) {
	 * registry.addViewController("/").setViewName("index");
	 * registry.addViewController("/login").setViewName("index"); }
	 * 
	 * @Override public Validator getValidator() { LocalValidatorFactoryBean factory
	 * = new LocalValidatorFactoryBean();
	 * factory.setValidationMessageSource(messageSource); return factory; }
	 * 
	 * 
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { BCryptPasswordEncoder
	 * bCryptPasswordEncoder = new BCryptPasswordEncoder(); return
	 * bCryptPasswordEncoder; }
	 */
}
