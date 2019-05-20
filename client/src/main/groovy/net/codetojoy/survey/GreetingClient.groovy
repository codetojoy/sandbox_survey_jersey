
package net.codetojoy.survey 

import net.codetojoy.survey.model.*

import javax.ws.rs.client.*
import javax.ws.rs.core.*

class GreetingClient {
    static final def BASE_URI = "http://localhost:5151/survey_jersey/rest"

    def getGreetingResource(def userId) {
        def client = ClientBuilder.newClient()
        def target = client.target(BASE_URI)
        def resource = target.path("greetings").queryParam("userId", userId)
        return resource
    }

    def getGreetingById(def id) {
        def resource = getGreetingResource(id)
        def builder = resource.request(MediaType.APPLICATION_JSON)
        def invocation = builder.buildGet()
        def responseType = new GenericType<Greeting>() {}
        def greeting = invocation.invoke(responseType)
        return greeting
    }

    final def GET_BY_ID = "1" 

    def processCommand() {
        Prompt prompt = new Prompt()
        String input = prompt.getInput("\n\ncmd: [1=get by id, Q=quit] ?", 
                                        GET_BY_ID)

        if (input.equalsIgnoreCase(GET_BY_ID)) {
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

