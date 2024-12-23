package com.example;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
@Path("/api")
public class GreetingResource {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/hello-reactive")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<String> helloReactive(){
        return Uni.createFrom().item("Hello Reactive");
    }
}
