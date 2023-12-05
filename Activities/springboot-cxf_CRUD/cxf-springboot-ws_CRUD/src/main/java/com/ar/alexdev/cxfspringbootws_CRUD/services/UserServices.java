package com.ar.alexdev.cxfspringbootws_CRUD.services;

import com.ar.alexdev.cxfspringbootws_CRUD.models.User;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface UserServices {
    @WebMethod(operationName = "getUsers")
    @WebResult(name = "users")
    List<User> getAll();

    @WebMethod(operationName = "deleteUser")
    @WebResult(name = "userDeleted")
    User deleteUser(@WebParam(name = "dni") String dni);

    @WebMethod(operationName = "saveUser")
    @WebResult(name = "userSaved")
    User saveUser(@WebParam(name = "user") User user);

    @WebMethod(operationName = "updateUser")
    @WebResult(name = "userUpdated")
    User updateUser(@WebParam(name = "user") User user);

    @WebMethod(operationName = "foundUser")
    @WebResult(name = "userFounded")
    User getUser(@WebParam(name = "dni") String dni);
}
