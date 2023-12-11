package com.ar.alexdev.backendspringboot.repositories;

import com.ar.alexdev.backendspringboot.models.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    List<Profession> findByName(String name);
}
