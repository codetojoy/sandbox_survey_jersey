package net.codetojoy.survey.resource;

import net.codetojoy.survey.model.Greeting;
import net.codetojoy.survey.service.GreetingService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.util.*;

@Path("/greetings")
public class GreetingResource {
    private GreetingService greetingService = new GreetingService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Greeting> getGreetings() {
        List<Greeting> greetings = greetingService.getGreetings();

        return greetings;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting getGreeting(@PathParam("id") long id) {
        Greeting greeting = greetingService.getGreeting(id);

        return greeting;
    }

    // TODO: return location header ???
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createGreeting(Greeting greeting) {
        greetingService.createGreeting(greeting);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateGreeting(@PathParam("id") long id, Greeting greeting) {
        greetingService.updateGreeting(id, greeting);
    }
}
