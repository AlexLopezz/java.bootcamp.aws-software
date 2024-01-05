package com.ar.alexdev.cxfspringbootrs_CRUD.repositories;

import com.ar.alexdev.cxfspringbootrs_CRUD.models.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    List<Profession> findByName(String name);
}