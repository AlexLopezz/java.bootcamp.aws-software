package com.ar.alexdev.backendspringboot.repositories;

import com.ar.alexdev.backendspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
