package com.alexdev.springboot_CRUD.mapper;

public interface Mapper <E, D> {
    E toEntity(D d);
    D toDTO(E e);
}
