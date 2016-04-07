package com.ratman.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/helloController")
public class HelloController {

	@Autowired
	@Qualifier("helloService")
	private HelloService helloService;

	@GET
	@Path("/hello")
	public String hello() {
		helloService.service();
	}
}
