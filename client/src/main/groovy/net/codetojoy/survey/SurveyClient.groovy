
package net.codetojoy.survey

import net.codetojoy.survey.model.*

import javax.ws.rs.client.*
import javax.ws.rs.core.*

class SurveyClient {
    static final def BASE_URI = "http://localhost:5151/survey_jersey/rest/v1"

    def getSurveysResource() {
        def client = ClientBuilder.newClient()
        def target = client.target(BASE_URI)
        def resource = target.path("surveys")
        return resource
    }

    def getGreetingResource(def id) {
        def resource = getGreetingsResource().path(id)
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

    def getGreetingById(def id) {
        def resource = getGreetingResource(id)
        def builder = resource.request(MediaType.APPLICATION_JSON)
        def invocation = builder.buildGet()
        def responseType = new GenericType<Greeting>() {}
        def greeting = invocation.invoke(responseType)
        return greeting
    }

    def postNewGreeting(def content) {
        def greeting = new Greeting()
        greeting.setContent(content)
        def resource = getGreetingsResource()
        def builder = resource.request(MediaType.APPLICATION_JSON)
        builder.post(javax.ws.rs.client.Entity.entity(greeting,
                     javax.ws.rs.core.MediaType.APPLICATION_JSON))
    }

    def updateGreetingById(def id, def content) {
        def greeting = new Greeting(id as long, content)
        def resource = getGreetingResource(id)
        def builder = resource.request(MediaType.APPLICATION_JSON)
        builder.put(javax.ws.rs.client.Entity.entity(greeting,
                    javax.ws.rs.core.MediaType.APPLICATION_JSON))
    }

    final def GET_SURVEYS = "1"
    final def GET_SURVEY_BY_ID = "2"
    final def POST_NEW_SURVEY = "3"
    final def PUT_UPDATE_SURVEY = "4"
    final def COMMANDS = [GET_SURVEYS, GET_SURVEY_BY_ID,
                          POST_NEW_SURVEY, PUT_UPDATE_SURVEY]

    def processCommand() {
        def prompt = new Prompt()
        def commandsStr = "1=get all, 2=get by id, 3=post new, 4=update by id"
        def input = prompt.getInput("\n\ncmd: [${commandsStr}, Q=quit] ?", COMMANDS)

        if (input.equalsIgnoreCase(GET_SURVEYS)) {
            def greetings = getSurveys()
            greetings.each { println it }
        } else if (input.equalsIgnoreCase(GET_SURVEY_BY_ID)) {
            // def id = prompt.getInput("enter greeting id: ")
            // def greeting = getGreetingById(id)
            // println "Greeting: " + greeting.toString()
        } else if (input.equalsIgnoreCase(POST_NEW_SURVEY)) {
            // def content = prompt.getInput("enter greeting: ")
            // def greeting = postNewGreeting(content)
            //  println "OK"
        } else if (input.equalsIgnoreCase(PUT_UPDATE_SURVEY)) {
            // def id = prompt.getInput("enter greeting id: ")
            // def content = prompt.getInput("enter greeting: ")
            // def greeting = updateGreetingById(id, content)
            // println "OK"
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
