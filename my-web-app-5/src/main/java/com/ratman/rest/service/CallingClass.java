package com.ratman.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Component;

@Component
@Path("/calling-class")
public class CallingClass {
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	public String getPodcasts() {
		
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		
		String url = System.getenv("WEB4_URL") + "/my-web-app-4/randomInt";
		System.out.println("url:" + url);
		
		WebTarget webTarget = client.target(url);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.TEXT_PLAIN_TYPE);
		Response response = invocationBuilder.get();
		
		StringBuilder sb = new StringBuilder();
		sb.append("status:" + response.getStatus());
		sb.append("response:" + response.readEntity(String.class));
		
		return sb.toString();
	}
}