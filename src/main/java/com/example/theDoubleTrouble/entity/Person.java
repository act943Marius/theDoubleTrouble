package com.example.theDoubleTrouble.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String nachname;
    @NotNull
    private String skill;

    public Person(){}


    public Person(String name, String nachname, String skill) {
        this.name = name;
        this.nachname = nachname;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}