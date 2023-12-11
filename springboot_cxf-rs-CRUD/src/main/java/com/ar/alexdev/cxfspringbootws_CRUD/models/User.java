package com.ar.alexdev.cxfspringbootws_CRUD.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name="db_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class User {
    @Id
    @Column(name = "dni")
    private String DNI;
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_birth")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dateBirth;

    @ManyToOne(
            optional = false,
            cascade = CascadeType.DETACH,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "profession_fk", nullable = false)
    private Profession profession;

    @Override
    public boolean equals(Object o) {
        if(o instanceof User u)
            return this.getDNI().equals(u.getDNI());


        return false;
    }
}