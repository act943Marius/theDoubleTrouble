package com.example.theDoubleTrouble.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Diese Klasse soll die Rechnungen der Teilnehmer darstellen.
 */
@Entity
@Table
public class Rechnung {
    @Id
    @GeneratedValue
    private Integer id;

    private Double kosten;

    public Rechnung(Integer id, Double kosten) {
        this.id = id;
        this.kosten = kosten;
    }

    public Rechnung() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getKosten() {
        return kosten;
    }

    public void setKosten(Double kosten) {
        this.kosten = kosten;
    }
}
