package com.alexdev.springboot_CRUD.services;

import com.alexdev.springboot_CRUD.models.Profession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IProfessionService {
    Profession save(Profession p);
    List<Profession> getAll();
    Optional<Profession> findByName(String name);
    void saveAll(Iterable<Profession> professions);
}