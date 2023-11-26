package com.ar.alexdev.backendspringboot.services.implementations;

import com.ar.alexdev.backendspringboot.models.Profession;
import com.ar.alexdev.backendspringboot.repositories.ProfessionRepository;
import com.ar.alexdev.backendspringboot.services.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    ProfessionRepository repository;


    @Override
    public List<Profession> getAll() {
        return repository.findAll();
    }

    @Override
    public Profession save(Profession p) {
        return repository.save(p);
    }

    @Override
    public void saveAll(List<Profession> professions) {
        repository.saveAll(professions);
    }

    @Override
    public Optional<Profession> findByName(String name) {
        return repository.findByName(name)
                .stream()
                .findFirst();
    }
}
