package com.alexdev.springboot_CRUD.controllers;

import com.alexdev.springboot_CRUD.models.Role;
import com.alexdev.springboot_CRUD.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    IRoleService service;

    @GetMapping
    public ResponseEntity<?> getAllRoles(){
        List<Role> roles = service.getAll();
        int status = roles.isEmpty()? 204 : 200;

        return ResponseEntity.status(status).body(roles);
    }
    @PostMapping
    public ResponseEntity<?> postRole(@RequestBody Role role){
        Role roleSaved = service.save(role);

        return ResponseEntity.status(201).body(roleSaved);
    }
    @PutMapping
    public ResponseEntity<?> putRole(@RequestBody Role role){
        service.getById(role.getId())
                .ifPresentOrElse(r -> service.save(r), () -> { throw new RuntimeException(); });

        return ResponseEntity.ok(role);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleBy(@PathVariable Long id){
        Role role = service.getById(id)
                .orElseThrow();

        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoleBy(@PathVariable Long id){
        service.getById(id)
                        .ifPresentOrElse(r -> service.deleteById(r.getId()),
                                () -> { throw new RuntimeException(); });

        return ResponseEntity.ok().build();
    }
}
