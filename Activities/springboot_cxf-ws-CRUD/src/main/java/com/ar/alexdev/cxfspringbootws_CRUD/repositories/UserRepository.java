package com.ar.alexdev.cxfspringbootws_CRUD.repositories;

import com.ar.alexdev.cxfspringbootws_CRUD.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> { }
