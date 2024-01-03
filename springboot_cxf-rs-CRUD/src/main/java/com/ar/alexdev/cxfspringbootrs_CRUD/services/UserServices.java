package com.ar.alexdev.cxfspringbootrs_CRUD.services;

import com.ar.alexdev.cxfspringbootrs_CRUD.models.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public interface UserServices {
    @GET
    List<User> getAll();

    @POST
    Response saveUser(User user);

    @PUT
    Response updateUser(User user);

    @GET
    @Path("/{dni}")
    Response getUser(@PathParam("dni") String dni);

    @DELETE
    @Path("/{dni}")
    Response deleteUser(@PathParam("dni") String dni);
}
