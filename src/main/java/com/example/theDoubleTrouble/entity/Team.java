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
    private String eMailAdresse;
    private Integer spieler1Id;
    private Integer spieler2Id;
    private String handynummer;
    private String passwort;

    public Team(String teamnamen, String eMailAdresse, Integer spieler1Id, Integer spieler2Id, String handynummer, String passwort) {
        this.teamnamen = teamnamen;
        this.eMailAdresse = eMailAdresse;
        this.spieler1Id = spieler1Id;
        this.spieler2Id = spieler2Id;
        this.handynummer = handynummer;
        this.passwort = passwort;
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

    public String getHandynummer() {
        return handynummer;
    }

    public void setHandynummer(String handynummer) {
        this.handynummer = handynummer;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
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
}
