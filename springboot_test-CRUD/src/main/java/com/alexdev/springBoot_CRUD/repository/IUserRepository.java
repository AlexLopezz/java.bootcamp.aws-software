package com.alexdev.springBoot_CRUD.repository;

import com.alexdev.springBoot_CRUD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, String> { }