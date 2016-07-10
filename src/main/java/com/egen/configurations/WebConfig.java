package com.egen.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({"com.egen.beans","com.egen.repositories","com.egen.service","com.egen.controllers"})
public class WebConfig {
	
	@Bean
	public ViewResolver getViewResolver()
	{
		InternalResourceViewResolver vs = new InternalResourceViewResolver();
		vs.setViewClass(JstlView.class);
		vs.setPrefix("/jsp-files/");
		vs.setSuffix(".jsp");
		return vs;
		
	}
	
}
