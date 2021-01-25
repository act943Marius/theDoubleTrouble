package com.example.theDoubleTrouble.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Team {

    @Id
    private Integer id;

    @Column(nullable = false, unique = true, length = 15)
    private String teamname;
    private Integer spieler1Id;
    private Integer spieler2Id;
    private boolean imSpiel;
    private String eMailAdresse;

    public Team(Integer id, String teamname, Integer spieler1Id, Integer spieler2Id, boolean imSpiel, String eMailAdresse) {
        this.id = id;
        this.teamname = teamname;
        this.spieler1Id = spieler1Id;
        this.spieler2Id = spieler2Id;
        this.imSpiel = imSpiel;
        this.eMailAdresse = eMailAdresse;
    }

    public Team() {

    }

    public String geteMailAdresse() {
        return eMailAdresse;
    }

    public void seteMailAdresse(String eMailAdresse) {
        this.eMailAdresse = eMailAdresse;
    }

    public Integer getSpieler1Id() {
        return spieler1Id;
    }

    public void setSpieler1Id(Integer spieler1Id) {
        this.spieler1Id = spieler1Id;
    }

    public Integer getSpieler2Id() {
        return spieler2Id;
    }

    public void setSpieler2Id(Integer spieler2Id) {
        this.spieler2Id = spieler2Id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamnamen) {
        this.teamname = teamnamen;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public boolean isImSpiel() {
        return imSpiel;
    }

    public void setImSpiel(boolean imSpiel) {
        this.imSpiel = imSpiel;
    }
}
