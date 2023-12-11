package com.alexdev.springboot_CRUD.services.impl;

import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.repositories.IProfessionRepository;
import com.alexdev.springboot_CRUD.services.IProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessioonService implements IProfessionService {
    @Autowired
    IProfessionRepository professionRepository;

    @Override
    public void saveAll(List<Profession> pr) {
        professionRepository.saveAll(pr);
    }

    @Override
    public List<Profession> getAll() {
        return professionRepository.findAll();
    }

    @Override
    public void save(Profession profession) {
        professionRepository.save(profession);
    }
}
