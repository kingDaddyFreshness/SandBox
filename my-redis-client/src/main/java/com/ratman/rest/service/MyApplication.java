package com.ratman.rest.service;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class MyApplication extends ResourceConfig {
 
    public MyApplication(){
		register(RequestContextFilter.class);
		register(MyResource.class);
		register(RedisResource.class);
		register(RandomInt.class);
		register(CallingClass.class);
		register(JacksonFeature.class);		
	}
}
