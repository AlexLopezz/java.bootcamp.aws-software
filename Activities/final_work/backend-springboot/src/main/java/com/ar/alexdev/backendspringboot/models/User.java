package com.ar.alexdev.backendspringboot.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "db_user")
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
    @DateTimeFormat(pattern= "yyyy/MM/dd")
    @Column(name = "date_birth")
    private Date dateBirth;

    @Enumerated(EnumType.STRING)
    private PROFESSION profession;
}
