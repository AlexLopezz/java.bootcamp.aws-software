package com.alexdev.springboot_CRUD.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;



@Entity
@Table(name= "db_user")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @NotEmpty(message = "Field must have a valid value")
    private String password;

    @NotNull(message = "Field must have a valid value")
    @ManyToOne(cascade = CascadeType.DETACH,
            optional = false,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "profession_fk", nullable = false)
    private Profession profession;

    @NotNull(message = "Field must have a valid value")
    @ManyToOne(cascade = CascadeType.DETACH,
            optional = false,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "role_fk", nullable = false)
    private Role role;
}