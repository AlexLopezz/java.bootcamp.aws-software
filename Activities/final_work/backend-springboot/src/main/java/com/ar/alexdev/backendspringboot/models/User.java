package com.ar.alexdev.backendspringboot.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class User {
    @Id
    private String dni;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_birth")
    @DateTimeFormat(pattern= "yyyy/MM/dd")
    private Date dateBirth;

    @ManyToOne
    @JoinColumn(name = "profession_fk", nullable = false)
    private Profession profession;
}
