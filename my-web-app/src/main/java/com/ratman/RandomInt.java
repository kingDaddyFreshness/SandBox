package com.ratman;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/randomInt")
public class RandomInt {
	
	private static Random random = new Random();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	Integer i = random.nextInt();
        return i.toString();
    }
}
