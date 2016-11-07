package com.ratman.rest.service;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class MyApplication extends ResourceConfig {
 
    public MyApplication(){
		register(RequestContextFilter.class);
		register(MyResource.class);
		register(PodcastRestService.class);
		register(CallingClass.class);
		register(CallMySql.class);
		register(RandomInt.class);
		register(JacksonFeature.class);		
	}
}
