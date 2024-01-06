package com.alexdev.springboot_CRUD.mapper;

import java.util.List;

public interface Mapper <E, D> {
    E toEntity(D d);
    D toDTO(E e);
}
