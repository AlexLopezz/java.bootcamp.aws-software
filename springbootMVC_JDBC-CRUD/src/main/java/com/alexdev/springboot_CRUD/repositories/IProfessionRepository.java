package com.alexdev.springboot_CRUD.repositories;

import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface IProfessionRepository {
    List<Profession> findAll();

    Optional<Profession> findById(Long id);

    void save(Profession p);

    void saveAll(List<Profession> professions);
}