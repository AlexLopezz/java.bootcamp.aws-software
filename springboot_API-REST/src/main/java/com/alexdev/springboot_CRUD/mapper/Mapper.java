package com.alexdev.springboot_CRUD.mapper;

import java.util.List;

public interface Mapper <E, D> {
    E toEntity(D d);
    List<E> toEntities(List<D> ds);
    D toDTO(E e);
    List<D> toDTOs(List<E> es);
}
