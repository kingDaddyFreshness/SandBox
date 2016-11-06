package com.ratman.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/calling")
public class CallingClass {

	@GET
	@Produces({MediaType.TEXT_PLAIN})
	public String getPodcasts() {
		
		Client client = ClientBuilder.newClient();
		Response res = client.target("http://SERVER-2:8080/docker-intro-2-1.0-SNAPSHOT/myresource").request("text/plain").get();
		boolean i1 = res.bufferEntity();
		boolean i2 = res.hasEntity();
		String s = res.readEntity(String.class);
		return "received 1:" + i1 + " 2:" + i2 + " 3:" + s;
	}

}
