package com.jmh.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("status")
public class Status {
	
	private static long failUntilTime = 0L;

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStatus(@QueryParam(value = "seconds") String secondsToFail) {
		
		long now = System.currentTimeMillis();
		if (secondsToFail != null) {
			failUntilTime = (Long.valueOf(secondsToFail) * 1000) + now;
		}
		else {
			if (failUntilTime <= now) {
				return Response.ok("{\"status\":\"healthy\"}", MediaType.APPLICATION_JSON).build();
			}
		}
		return Response.status(400).build();
    }
}
