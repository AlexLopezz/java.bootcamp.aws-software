package com.alexdev.springBoot_CRUD.repository;

import com.alexdev.springBoot_CRUD.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> { }