package com.ar.alexdev.cxfspringbootws_CRUD.services;

import com.ar.alexdev.cxfspringbootws_CRUD.models.User;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface UserServices {
    @WebMethod(operationName = "listUser")
    @WebResult(name = "user")
    List<User> getAll();

    @WebMethod(operationName = "deleteUser")
    @WebResult(name = "message")
    String deleteUser(@WebParam(name = "dni") Long DNI);

    @WebMethod(operationName = "addUser")
    @WebResult(name = "message")
    String saveUser(@WebParam(name = "user") User user);

    @WebMethod(operationName = "updateUser")
    @WebResult(name = "message")
    String updateUser(@WebParam(name = "user") User user);
}
