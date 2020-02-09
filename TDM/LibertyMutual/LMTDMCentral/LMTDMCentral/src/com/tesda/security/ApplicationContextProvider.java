package com.tesda.security;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:spring-config.xml")
public class ApplicationContextProvider implements ApplicationContextAware{

	
	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext ac)
			throws BeansException {
		context = ac;
	}
	
	public ApplicationContext getApplicationContext(){
		return context;
	}
	

}

