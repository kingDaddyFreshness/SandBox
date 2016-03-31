package com.ratman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class RandomIntTest extends JerseyTest {
 
    @Override
    protected Application configure() {
        return new ResourceConfig(RandomInt.class);
    }
 
    @Test
    public void testRandonInt() {
        final String intString = target("randomInt").request().get(String.class);
        try {
        	Integer i = Integer.parseInt(intString);
        }
        catch(NumberFormatException e) {
        	fail("could not convert response to integer");
        }
    }
}
