package com.alexdev.springboot_CRUD.mapper;

public interface IUserMapper <E, REQ, RES>{
    E fromReqToEntity(REQ req);
    E fromRespToEntity(RES res);
    RES fromEntityToResponse(E e);
}
