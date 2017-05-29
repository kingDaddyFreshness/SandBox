package com.jmh.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jmh.utility.CpuBurn;

@Path("burnCpu")
public class BurnCpu {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response burnCpu() {
		
		CpuBurn.burnCpu();
		
		return Response.ok("{\"burn\":\"go\"}", MediaType.APPLICATION_JSON).build();
    }

}
