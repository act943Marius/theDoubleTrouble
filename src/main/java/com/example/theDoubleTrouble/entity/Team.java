package com.example.theDoubleTrouble.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Team {

    @Id
    private Integer id;

    private String teamnamen;
    private Integer spieler1Id;
    private Integer spieler2Id;
    private boolean imSpiel;

    public Team(Integer id, String teamnamen, Integer spieler1Id, Integer spieler2Id, boolean imSpiel) {
        this.id = id;
        this.teamnamen = teamnamen;
        this.spieler1Id = spieler1Id;
        this.spieler2Id = spieler2Id;
        this.imSpiel = imSpiel;
    }

    public Team() {

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

    public String getTeamnamen() {
        return teamnamen;
    }

    public void setTeamnamen(String teamnamen) {
        this.teamnamen = teamnamen;
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
