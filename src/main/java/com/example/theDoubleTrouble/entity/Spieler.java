package com.example.theDoubleTrouble.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Spieler")
public class Spieler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String vorname;
    private String nachname;
    private Date geburtsdatum;
    private Integer rechnungsNummer;

    public Spieler(String vorname, String nachname, Date geburtsdatum, Integer rechnungsNummer) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.rechnungsNummer = rechnungsNummer;
    }

    public Spieler() {

    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public Integer getRechnungsNummer() {
        return rechnungsNummer;
    }

    public void setRechnungsNummer(Integer rechnungsNummer) {
        this.rechnungsNummer = rechnungsNummer;
    }
}
