
@Grab(group='org.glassfish.jersey.core', module='jersey-client', version='2.5.1')
@Grab(group='org.glassfish.jersey.media', module='jersey-media-moxy', version='2.5.1')

import net.codetojoy.survey.model.*

import javax.ws.rs.client.*
import javax.ws.rs.core.*

// ------- main

final def BASE_URI = "http://localhost:5151/survey_jersey/rest"

def getResource = { userId ->
    def client = ClientBuilder.newClient()
    def target = client.target(BASE_URI)
    def resource = target.path("greetings").queryParam("userId", userId)
    return resource
}

def resource = getResource("222")
def builder = resource.request(MediaType.APPLICATION_JSON)
def invocation = builder.buildGet()
def responseType = new GenericType<Greeting>() {}
def greeting = invocation.invoke(responseType)

println "greeting: " + greeting.toString()

println "Ready."
