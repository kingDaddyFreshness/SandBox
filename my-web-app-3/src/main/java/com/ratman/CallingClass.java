package com.ratman;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.WebResource;

@Path("calling-class")
public class CallingClass {

//	private Client client = Client.create();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		
//		WebResource webResource = client.resource("http://localhost:8080/my-web-app/webapi/myresource");
//		String s = webResource.get(String.class);
		
		
		return "here's what I got: fix me in the code!";
	}
}
