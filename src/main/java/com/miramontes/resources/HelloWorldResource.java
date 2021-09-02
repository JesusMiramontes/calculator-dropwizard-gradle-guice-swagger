package com.miramontes.resources;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
@Singleton
@Produces(MediaType.TEXT_PLAIN)
public class HelloWorldResource {

    @GET
    @Path("/{name:.*}")
    public Response helloWorld(@PathParam("name") String name){
        return Response.ok("Hello " + name).build();
    }
}
