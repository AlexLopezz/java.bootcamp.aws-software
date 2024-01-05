package com.ar.alexdev.cxfspringbootrs_CRUD.services;

import com.ar.alexdev.cxfspringbootrs_CRUD.models.DTO.UserDTO;
import com.ar.alexdev.cxfspringbootrs_CRUD.models.User;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserServices {
    @GET
    Response getAll();

    @POST
    Response saveUser(UserDTO user);

    @PUT
    Response updateUser(UserDTO user);

    @GET
    @Path("/{dni}")
    Response getUser(@PathParam("dni") String dni);

    @DELETE
    @Path("/{dni}")
    Response deleteUser(@PathParam("dni") String dni);
}
