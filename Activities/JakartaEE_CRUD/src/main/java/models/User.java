package models;

import models.enums.GENDER;
import models.enums.PROFESSION;

import java.time.LocalDate;

public class User {
    private static int staticID = 0;

    private int id;
    private int DNI;
    private String name;
    private String lastName;
    private LocalDate dateBirth;
    private GENDER gender;
    private PROFESSION profession;


    public User() {
        id = ++staticID;
    }

    public int getId() {
        return id;
    }

    public int getDNI() {
        return DNI;
    }

    public User setDNI(int DNI) {
        this.DNI = DNI;

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

    public GENDER getGender() {
        return gender;
    }

    public User setGender(GENDER gender) {
        this.gender = gender;

        return this;
    }

    public PROFESSION getProfession() {
        return profession;
    }

    public User setProfession(PROFESSION profession) {
        this.profession = profession;

        return this;
    }
}