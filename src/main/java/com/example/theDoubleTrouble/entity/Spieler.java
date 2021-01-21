package com.example.theDoubleTrouble.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Spieler")
public class Spieler {


    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String vorname;
    private String nachname;
    private Long telefonnummer;

    public Spieler(Integer id, String vorname, String nachname, Long telefonnummer) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.telefonnummer = telefonnummer;
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

    public Long getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(Long telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
