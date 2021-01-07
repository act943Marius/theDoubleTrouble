package com.example.theDoubleTrouble.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Court {

    public Court(){}

    @Id
    private Integer id;

    @NotNull
    private int courtNummer;

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }
}
