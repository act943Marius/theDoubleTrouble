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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }




}
