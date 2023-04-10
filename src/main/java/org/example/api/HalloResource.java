package org.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/tasks")
public class HalloResource {

    @GET
    public Response hallo() {
        return Response.ok("Message").build();
    }
}
