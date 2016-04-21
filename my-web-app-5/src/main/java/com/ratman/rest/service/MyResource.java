package com.ratman.rest.service;

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
	public String getPodcasts() {
		return "hello john from my-web-app-5!";
	}
}
