package com.example.theDoubleTrouble.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Spielkarte {

    @Id
    private Integer id;
    private String teamname;
    private Integer anzahlSiege;
    private Double punkteDifferenz;

    public Spielkarte(Integer id, String teamname, Integer anzahlSiege, Double punkteDifferenz) {
        this.id = id;
        this.teamname = teamname;
        this.anzahlSiege = anzahlSiege;
        this.punkteDifferenz = punkteDifferenz;
    }

    public Spielkarte() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public Integer getAnzahlSiege() {
        return anzahlSiege;
    }

    public void setAnzahlSiege(Integer anzahlSiege) {
        this.anzahlSiege = anzahlSiege;
    }

    public Double getPunkteDifferenz() {
        return punkteDifferenz;
    }

    public void setPunkteDifferenz(Double punkteDifferenz) {
        this.punkteDifferenz = punkteDifferenz;
    }
}
