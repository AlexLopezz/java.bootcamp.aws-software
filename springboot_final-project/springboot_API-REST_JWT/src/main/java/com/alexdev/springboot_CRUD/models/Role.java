package com.alexdev.springboot_CRUD.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "db_role")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}