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
        List<User> users = DataBase.getUsers();
        return Response.ok(users).build();
    }

    @POST
    public Response createNewUser(User user) {
        DataBase.addUser(user);
        return Response.ok(true).build();
    }

    @POST
    @Path("create")
    public Response createDummyUsers() {
        System.out.println("Creating dummy users.");

        User u = new User();
        u.setId(0);
        u.setFirstName("Luka");
        u.setLastName("Podgorsek");

        User u1 = new User();
        u1.setId(1);
        u1.setFirstName("Dummy");
        u1.setLastName("User1");

        User u2 = new User();
        u2.setId(2);
        u2.setFirstName("Dummy");
        u2.setLastName("User2");

        DataBase.addUser(u);
        DataBase.addUser(u1);
        DataBase.addUser(u2);

        return Response.ok(DataBase.getUsers()).build();
    }
}

