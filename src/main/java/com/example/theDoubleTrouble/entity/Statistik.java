package com.example.theDoubleTrouble.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Statistik {

    @Id
    private Integer id;

    private List<Spiel> spielListe = new ArrayList<>();

    public Statistik(){}

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }
}
