
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

    def go() {
        def resource = getGreetingResource("222")
        def builder = resource.request(MediaType.APPLICATION_JSON)
        def invocation = builder.buildGet()
        def responseType = new GenericType<Greeting>() {}
        def greeting = invocation.invoke(responseType)

        println "Greeting: " + greeting.toString()
    }

    static void main(String[] args) {
        def client = new GreetingClient()
        client.go()

        println "Ready."
    }
}

