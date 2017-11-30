package com.rsostream.dummyProducer;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("producer")
@ApplicationScoped
public class ProducerResource {

    @Inject
    private ConfigProperties properties;

    @GET
    @Path("/config")
    public Response test() {
        String response =
                "{" +
                        "\"stringProperty\": \"%s\"," +
                        "\"booleanProperty\": %b," +
                        "\"integerProperty\": %d" +
                        "}";

        response = String.format(
                response,
                properties.getStringProperty(),
                properties.getBooleanProperty(),
                properties.getIntegerProperty());

        return Response.ok(response).build();
    }

    @GET
    public Response getUsers() {
        List<Movie> users = DataBase.getMovies();
        return Response.ok(users).build();
    }

    @POST
    public Response createNewMovie(Movie m) {
        DataBase.addMovie(m);
        return Response.ok(true).build();
    }

    @POST
    @Path("create")
    public Response createDummyUsers() {
        if (DataBase.isEmpty()) {
            System.out.println("Creating dummy movies.");

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
        }

        return Response.ok(DataBase.getMovies()).build();
    }
}

