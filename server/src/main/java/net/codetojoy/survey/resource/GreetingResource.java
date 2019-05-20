package net.codetojoy.survey;

import net.codetojoy.survey.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.util.*;
import java.util.stream.*;

@Path("/greetings")
public class GreetingResource {
    // This is obviously a toy example.
    private static Map<Long,Greeting> mockStorage = new HashMap<>();
    private static long nextId = 0L;

    static {
        mockStorage.put(111L, new Greeting(111L, "This is greeting 1"));
        mockStorage.put(222L, new Greeting(222L, "This is greeting 2"));
        mockStorage.put(333L, new Greeting(333L, "This is greeting 3"));
        nextId = 334;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Greeting> getGreetings() {
        System.out.println("TRACER 20-MAY SR greetings");
        
        List<Greeting> greetings = mockStorage.entrySet()
                                              .stream()
                                              .map(Map.Entry::getValue)
                                              .collect(Collectors.toList());

        return greetings;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting getGreeting(@PathParam("id") long id) {
        System.out.println("TRACER 20-MAY SR id: " + id);
        Greeting greeting = mockStorage.get(id);
 
        return greeting;
    }

    // TODO: return location header ??? 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createGreeting(Greeting greeting) {
        greeting.setId(nextId);
        mockStorage.put(nextId, greeting);
        nextId++; 
    } 

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateGreeting(@PathParam("id") long id, Greeting greeting) {
        mockStorage.put(id, greeting);
    } 
}
