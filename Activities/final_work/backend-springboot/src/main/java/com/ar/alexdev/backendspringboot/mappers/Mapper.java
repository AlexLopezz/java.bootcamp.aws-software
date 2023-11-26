package com.ar.alexdev.backendspringboot.mappers;

import java.util.List;

public interface Mapper<T,V> {
    T mapToDTO (V v);
    V mapToEntity(T t);
    List<T> mapToDTOs(List<V> v);
    List<V> mapToEntities(List<T> v);
}
