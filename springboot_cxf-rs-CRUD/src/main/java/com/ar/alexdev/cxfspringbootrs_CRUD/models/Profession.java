package com.ar.alexdev.cxfspringbootrs_CRUD.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Entity(name = "db_profession")
@XmlRootElement(name = "profession")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
