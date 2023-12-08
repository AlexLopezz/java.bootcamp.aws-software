package com.alexdev.springboot_CRUD.services;

import com.alexdev.springboot_CRUD.models.Profession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProfessionService {
    List<Profession> getAll();
    void save(Profession profession);
    void saveAll(List<Profession> professions);
}