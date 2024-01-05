package com.ar.alexdev.cxfspringbootws_CRUD.services;

import com.ar.alexdev.cxfspringbootws_CRUD.models.DTO.UserDTO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface UserServices {
    @WebMethod(operationName = "getAll")
    @WebResult(name = "users")
    List<UserDTO> getAll();

    @WebMethod(operationName = "delete")
    void deleteUser(@WebParam(name = "dni") String dni);

    @WebMethod(operationName = "save")
    @WebResult(name = "saved")
    UserDTO saveUser(@WebParam(name="userDTO") UserDTO user);

    @WebMethod(operationName = "update")
    @WebResult(name = "updated")
    UserDTO updateUser(@WebParam(name="userDTO") UserDTO user);

    @WebMethod(operationName = "getById")
    @WebResult(name = "founded")
    UserDTO getUser(@WebParam(name = "dni") String dni);
}
