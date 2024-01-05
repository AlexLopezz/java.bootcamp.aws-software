package com.ar.alexdev.cxfspringbootrs_CRUD.models;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
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
    private String dni;

    private String name;

    private String lastName;

    @Temporal(TemporalType.DATE)
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
            return this.getDni().equals(u.getDni());


        return false;
    }
}