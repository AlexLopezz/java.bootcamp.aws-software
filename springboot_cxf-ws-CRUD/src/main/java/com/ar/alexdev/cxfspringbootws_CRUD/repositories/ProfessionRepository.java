package com.ar.alexdev.cxfspringbootws_CRUD.repositories;

import com.ar.alexdev.cxfspringbootws_CRUD.models.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    List<Profession> findByName(String name);
}
