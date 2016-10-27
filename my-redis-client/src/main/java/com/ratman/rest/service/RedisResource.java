package com.ratman.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

@Component
@Path("/redis")
public class RedisResource {
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	public String getPodcasts() {
		
		Jedis jedis = new Jedis("REDIS",6379);
		Long c = jedis.incr("aaa");
		
		return "hello john:" + c;
	}
}