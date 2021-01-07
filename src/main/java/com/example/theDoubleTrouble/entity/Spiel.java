package com.example.theDoubleTrouble.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Spiel {

    @Id
    private Integer id;

    private SpielModus spielModus;
    private Team team1;
    private Team team2;
    private Court court;
    private Date spielzeit;
    private int team1Punkte;
    private int team2Punkte;

    public Spiel(){}

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }
}
