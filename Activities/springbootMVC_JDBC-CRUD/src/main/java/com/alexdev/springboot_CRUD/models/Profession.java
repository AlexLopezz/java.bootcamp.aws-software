package com.alexdev.springboot_CRUD.models;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "db_profession")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 80)
    private String name;
}
