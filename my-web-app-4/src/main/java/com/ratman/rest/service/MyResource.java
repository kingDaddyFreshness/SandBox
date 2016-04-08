package com.ratman.rest.service;

import java.util.Iterator;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/myresource")
public class MyResource {
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	public String getStuff() {
		
		System.out.println(System.getenv("WEBA"));
		System.out.println(System.getenv("WEBB"));
		
		Map<String,String> vars = System.getenv();
		Iterator<String> i = vars.keySet().iterator();
		while (i.hasNext()) {
			String key = i.next();
			System.out.println("key:" + key + " value:" + vars.get(key));
		}
		
		return "hello john from my-web-app-4!";
	}
}
