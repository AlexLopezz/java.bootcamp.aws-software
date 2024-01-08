package com.alexdev.springboot_CRUD.repositories;

import com.alexdev.springboot_CRUD.models.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProfessionRepository extends JpaRepository<Profession, Long> {
    Optional<Profession> findByName(String name);
}
