package com.alexdev.springboot_CRUD.repositories;

import com.alexdev.springboot_CRUD.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {  }