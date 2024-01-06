package com.alexdev.springboot_CRUD.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name= "db_role")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Role r)
            return this.name.equals(r.getName());

        return false;
    }
}