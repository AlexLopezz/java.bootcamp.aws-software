package com.alexdev.springboot_CRUD.repositories.impl;

import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.repositories.IProfessionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfessionRepository implements IProfessionRepository {
    @Override
    public List<Profession> findAll() {
        return null;
    }

    @Override
    public Profession save(Profession p) {
        return null;
    }

    @Override
    public void saveAll(List<Profession> professions) {

    }
}
