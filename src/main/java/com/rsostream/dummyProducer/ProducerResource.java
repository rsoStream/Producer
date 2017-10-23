package com.rsostream.dummyProducer;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("producer")
public class ProducerResource {
    @GET
    public Response getAllUser() {
        List<Movie> users = DataBase.getMovies();
        return Response.ok(users).build();
    }

    @POST
    public Response createNewUser(Movie m) {
        DataBase.addMovie(m);
        return Response.ok(true).build();
    }

    @POST
    @Path("create")
    public Response createDummyUsers() {
        System.out.println("Creating dummy users.");

        Movie m = new Movie();
        m.setId(0);
        m.setName("Blade runner 2049");
        m.setGenre("SciFi");

        Movie m1 = new Movie();
        m1.setId(1);
        m1.setName("Blade runner");
        m1.setGenre("SciFi");

        DataBase.addMovie(m);
        DataBase.addMovie(m1);

        return Response.ok(DataBase.getMovies()).build();
    }
}

