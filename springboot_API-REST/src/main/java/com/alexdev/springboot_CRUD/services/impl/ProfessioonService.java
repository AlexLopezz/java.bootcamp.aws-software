package com.alexdev.springboot_CRUD.services.impl;

import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.repositories.IProfessionRepository;
import com.alexdev.springboot_CRUD.services.IProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessioonService implements IProfessionService {
    @Autowired
    IProfessionRepository professionRepository;


    @Override
    public Profession save(Profession p) {
        return professionRepository.save(p);
    }

    @Override
    public void saveAll(Iterable<Profession> pr) {
        professionRepository.saveAll(pr);
    }

    @Override
    public List<Profession> getAll() {
        return professionRepository.findAll();
    }

    @Override
    public Optional<Profession> findByName(String name) {
        return professionRepository.findByName(name);
    }
}
