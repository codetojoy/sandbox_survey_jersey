package net.codetojoy.survey.resource;

import net.codetojoy.survey.model.Survey;
import net.codetojoy.survey.model.SurveyRequest;
import net.codetojoy.survey.model.UpdateSurveyRequest;
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

    // returns URI in Location header
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSurvey(SurveyRequest surveyRequest, @Context UriInfo uriInfo) {
        long userId = surveyRequest.getUserId();
        long surveyId = surveyService.createSurvey(userId);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path("" + surveyId);
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateSurvey(@PathParam("id") long id, UpdateSurveyRequest updateSurveyRequest) {
        surveyService.updateSurvey(id, updateSurveyRequest);
    }
}
