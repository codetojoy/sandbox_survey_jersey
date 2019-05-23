package net.codetojoy.survey.resource;

import net.codetojoy.survey.model.Survey;
import net.codetojoy.survey.service.SurveyService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.util.*;

@Path("/v1/surveys")
public class SurveyResource {
    private SurveyService surveyService = new SurveyService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Survey> getSurveys() {
        List<Survey> surveys = surveyService.getSurveys();

        return surveys;
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Survey getSurvey(@PathParam("id") long id) {
        Survey survey = surveyService.getSurvey(id);

        return survey;
    }

    /*

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
    */
}
