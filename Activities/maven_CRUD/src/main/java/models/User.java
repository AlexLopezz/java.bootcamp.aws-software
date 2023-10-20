package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.enums.PROFESSION;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
@Builder
@Getter @Setter
public class User {
    private String dni;
    private String name;
    private String lastName;
    private LocalDate dateBirth;
    private PROFESSION profession;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User u)
            return this.getDni().equals(u.getDni());

        return false;
    }

    @Override
    public String toString() {
        return dni.concat(";")
                .concat(name).concat(";")
                .concat(lastName).concat(";")
                .concat(dateBirth.toString()).concat(";")
                .concat(profession.name());
    }
}