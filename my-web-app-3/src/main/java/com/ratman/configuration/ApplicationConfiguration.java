package com.ratman.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
	@Bean
	HelloService helloService() {
		return new HelloServiceImpl();
	}
}