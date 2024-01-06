package com.alexdev.springboot_CRUD.repositories;

import com.alexdev.springboot_CRUD.models.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfessionRepository extends JpaRepository<Profession, String> {
    Optional<Profession> findByName(String name);
}