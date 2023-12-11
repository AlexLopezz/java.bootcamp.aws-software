package com.ar.alexdev.backendspringboot.services;

import com.ar.alexdev.backendspringboot.models.Profession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProfessionService {
    List<Profession> getAll();
    Profession save(Profession profession);
    void saveAll(List<Profession> professions);

    Optional<Profession> findByName(String name);
}
