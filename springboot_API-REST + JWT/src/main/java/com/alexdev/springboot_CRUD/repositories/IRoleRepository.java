package com.alexdev.springboot_CRUD.repositories;

import com.alexdev.springboot_CRUD.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
