
package net.codetojoy.survey

import net.codetojoy.survey.model.*

import javax.ws.rs.client.*
import javax.ws.rs.core.*
import javax.ws.rs.client.Entity

class SurveyClient {
    static final def BASE_URI = "http://localhost:5151/survey_jersey/rest/v1"

    def getSurveysResource() {
        def client = ClientBuilder.newClient()
        def target = client.target(BASE_URI)
        def resource = target.path("surveys")
        return resource
    }

    def getSurveyResource(def id) {
        def resource = getSurveysResource().path("" + id)
        return resource
    }

    def getSurveys() {
        def resource = getSurveysResource()
        def builder = resource.request(MediaType.APPLICATION_JSON)
        def invocation = builder.buildGet()
        def responseType = new GenericType<List<Survey>>() {}
        def surveys = invocation.invoke(responseType)
        return surveys
    }

    def getSurveyById(def id) {
        def resource = getSurveyResource(id)
        def builder = resource.request(MediaType.APPLICATION_JSON)
        def invocation = builder.buildGet()
        def responseType = new GenericType<Survey>() {}
        def survey = invocation.invoke(responseType)
        return survey
    }

    def postNewSurvey(def userIdStr) {
        long userId = userIdStr as Long
        def surveyRequest = new SurveyRequest()
        surveyRequest.userId = userId
        def resource = getSurveysResource()
        def builder = resource.request(MediaType.APPLICATION_JSON)
        def response = builder.post(Entity.entity(surveyRequest, MediaType.APPLICATION_JSON))
        def uri = response.getHeaderString("Location")
        return uri
    }

    def updateSurveyById(def surveyId, def answerIdsStr) {
        def updateSurveyRequest = new UpdateSurveyRequest()
        updateSurveyRequest.setSurveyId(surveyId)
        updateSurveyRequest.setUserId(555)

        def answers = []
        def answerIds = answerIdsStr.split(",")
        answerIds.each { answerId ->
            def answer = new Answer()
            answer.setId(answerId.trim() as long)
            answer.comment = "comment: " + new Date().toString()
            answers << answer
        }
        updateSurveyRequest.answers = answers

        /*
        println "sanity check surveyId: " + updateSurveyRequest.getSurveyId()
        println "sanity check userId: " + updateSurveyRequest.getUserId()
        updateSurveyRequest.answers.each {
            println it.toString()
        }
        println "end sanity check"
        */
        
        def resource = getSurveyResource(surveyId)
        def builder = resource.request(MediaType.APPLICATION_JSON)

        // builder.put(Entity.entity(updateSurveyRequest, MediaType.APPLICATION_JSON))
        builder.put(javax.ws.rs.client.Entity.entity(updateSurveyRequest,
                    javax.ws.rs.core.MediaType.APPLICATION_JSON))
    }

    final def GET_SURVEYS = "1"
    final def GET_SURVEY_BY_ID = "2"
    final def POST_NEW_SURVEY = "3"
    final def PUT_UPDATE_SURVEY = "4"
    final def CUSTOM_WORKFLOW = "5"
    final def COMMANDS = [GET_SURVEYS, GET_SURVEY_BY_ID,
                          POST_NEW_SURVEY, PUT_UPDATE_SURVEY, CUSTOM_WORKFLOW]

    def processCommand() {
        def prompt = new Prompt()
        def commandsStr = "1=get all, 2=get by id, 3=post new, 4=update by id, 5=workflow"
        def input = prompt.getInput("\n\ncmd: [${commandsStr}, Q=quit] ?", COMMANDS)

        if (input.equalsIgnoreCase(GET_SURVEYS)) {
            def surveys = getSurveys()
            surveys.each { println it }
        } else if (input.equalsIgnoreCase(GET_SURVEY_BY_ID)) {
            def id = prompt.getInput("enter survey id: ")
            def survey = getSurveyById(id)
            println "Survey: " + survey.toString()
        } else if (input.equalsIgnoreCase(POST_NEW_SURVEY)) {
            def userId = prompt.getInput("enter user id: ")
            def uri = postNewSurvey(userId)
            println "uri: " + uri
            println "OK"
        } else if (input.equalsIgnoreCase(PUT_UPDATE_SURVEY)) {
            println "TRACER 25-MAY 17:00"
            def surveyId = prompt.getInput("enter survey id: ")
            def answerIdsStr = prompt.getInput("enter answer ids to select: ")

            updateSurveyById(surveyId as long, answerIdsStr)
            println "OK"
        } else if (input.equalsIgnoreCase(CUSTOM_WORKFLOW)) {
            println "TBD"
        }
    }

    void inputLoop() {
        while (true) {
            try {
                processCommand()
            } catch(Exception ex) {
                System.err.println("\nTRACER command failed! check if the servlet is running \n")
                System.err.println("\nTRACER exceptionL: ${ex.message}")
            }
        }
    }

    static void main(String[] args) {
        def client = new SurveyClient()
        client.inputLoop()
    }
}
