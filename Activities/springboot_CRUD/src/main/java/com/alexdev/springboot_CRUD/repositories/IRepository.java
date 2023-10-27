package com.alexdev.springboot_CRUD.repositories;

import java.util.List;

public interface IRepository <T> {
    void save(T t);
    void delete(T t);
    List<T> getAll();
    void saveAll(List<T> tts);
}
