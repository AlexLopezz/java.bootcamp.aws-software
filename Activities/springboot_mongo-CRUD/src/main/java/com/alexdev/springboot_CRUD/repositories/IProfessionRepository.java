package com.alexdev.springboot_CRUD.repositories;

import com.alexdev.springboot_CRUD.models.Profession;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfessionRepository extends MongoRepository<Profession, String> {  }