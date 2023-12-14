package com.alexdev.springBoot_CRUD.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity(name="db_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class User {
    @Id
    private String dni;

    private String name;
    private String lastName;
    private Date dateBirth;

    @ManyToOne(targetEntity = Profession.class, fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "profession_fk")
    private Profession profession;
}
