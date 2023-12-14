package com.alexdev.springBoot_CRUD.repository;

import com.alexdev.springBoot_CRUD.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfessionRepository extends JpaRepository<Profession, Long> { }