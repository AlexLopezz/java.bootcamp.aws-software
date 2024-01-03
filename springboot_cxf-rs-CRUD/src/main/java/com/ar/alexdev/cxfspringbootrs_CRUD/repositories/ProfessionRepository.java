package com.ar.alexdev.cxfspringbootrs_CRUD.repositories;

import com.ar.alexdev.cxfspringbootrs_CRUD.models.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Long> { }