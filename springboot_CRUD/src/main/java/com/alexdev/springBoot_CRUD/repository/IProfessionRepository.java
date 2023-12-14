package com.alexdev.springBoot_CRUD.repository;

import com.alexdev.springBoot_CRUD.model.Profession;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessionRepository extends MongoRepository<Profession, String> { }