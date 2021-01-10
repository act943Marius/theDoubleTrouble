package com.example.theDoubleTrouble.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Spielplan {

    @Id
    private Integer id;

    private Integer spielID;

    public Spielplan(){}

    public Spielplan(Integer id, Integer spielID) {
        this.id = id;
        this.spielID = spielID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public Integer getSpielID() {
        return spielID;
    }

    public void setSpielID(Integer spielID) {
        this.spielID = spielID;
    }
}
