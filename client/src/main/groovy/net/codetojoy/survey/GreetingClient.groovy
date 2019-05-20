
package net.codetojoy.survey 

import net.codetojoy.survey.model.*

import javax.ws.rs.client.*
import javax.ws.rs.core.*

class GreetingClient {
    static final def BASE_URI = "http://localhost:5151/survey_jersey/rest"

    def getGreetingsResource() {
        def client = ClientBuilder.newClient()
        def target = client.target(BASE_URI)
        def resource = target.path("greetings")
        return resource
    }

    def getGreetingResource(def id) {
        def resource = getGreetingsResource().path(id)
        return resource
    }

    def getGreetings() {
        def resource = getGreetingsResource()
        def builder = resource.request(MediaType.APPLICATION_JSON)
        def invocation = builder.buildGet()
        def responseType = new GenericType<List<Greeting>>() {}
        def greetings = invocation.invoke(responseType)
        return greetings
    }

    def getGreetingById(def id) {
        def resource = getGreetingResource(id)
        def builder = resource.request(MediaType.APPLICATION_JSON)
        def invocation = builder.buildGet()
        def responseType = new GenericType<Greeting>() {}
        def greeting = invocation.invoke(responseType)
        return greeting
    }

    final def GET_GREETINGS = "1" 
    final def GET_GREETING_BY_ID = "2" 

    def processCommand() {
        Prompt prompt = new Prompt()
        String input = prompt.getInput("\n\ncmd: [1=get all, 2=get by id, Q=quit] ?", 
                                        GET_GREETINGS, GET_GREETING_BY_ID)

        if (input.equalsIgnoreCase(GET_GREETINGS)) {
            def greetings = getGreetings()
            greetings.each { println it }
        } else if (input.equalsIgnoreCase(GET_GREETING_BY_ID)) {
            String id = prompt.getInput("enter greeting id: "); 
            def greeting = getGreetingById(id);
            println "Greeting: " + greeting.toString()
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
        def client = new GreetingClient()
        client.inputLoop()
    }
}

