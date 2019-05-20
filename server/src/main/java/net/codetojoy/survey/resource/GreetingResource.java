package net.codetojoy.survey;

import net.codetojoy.survey.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.util.*;

@Path("/greetings")
public class GreetingResource {
    private static Map<Long,Greeting> mockStorage = new HashMap<>();

    static {
        mockStorage.put(111L, new Greeting(111L, "This is greeting 1"));
        mockStorage.put(222L, new Greeting(222L, "This is greeting 2"));
        mockStorage.put(333L, new Greeting(333L, "This is greeting 3"));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting getGreeting(@PathParam("id") long id) {
        System.out.println("TRACER 20-MAY SR id: " + id);
        Greeting greeting = mockStorage.get(id);
 
        return greeting;
    }
}
