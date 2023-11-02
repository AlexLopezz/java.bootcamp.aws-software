package models;

import models.enums.PROFESSION;

import java.time.LocalDate;

public class User {
    private String dni;
    private String name;
    private String lastName;
    private LocalDate dateBirth;
    private PROFESSION profession;


    public User(String dni, String name, String lastName, LocalDate dateBirth, PROFESSION profession) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.profession = profession;
    }

    public String getDni() {
        return dni;
    }

    public User setDni(String dni) {
        this.dni = dni;

        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;

        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;

        return this;

    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public User setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;

        return this;
    }

    public PROFESSION getProfession() {
        return profession;
    }

    public User setProfession(PROFESSION profession) {
        this.profession = profession;

        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User user){
            return this.getDni().equals(user.getDni());
        }

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
