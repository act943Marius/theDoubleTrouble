package com.example.theDoubleTrouble.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Court {

    public Court() {
    }

    public Court(Integer id, Integer courtNummer, Boolean besetzt) {
        this.id = id;
        this.courtNummer = courtNummer;
        this.besetzt = besetzt;
    }

    @Id
    private Integer id;

    @NotNull
    private Integer courtNummer;

    private Boolean besetzt;

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public int getCourtNummer() {
        return courtNummer;
    }

    public void setCourtNummer(int courtNummer) {
        this.courtNummer = courtNummer;
    }

    public Boolean getBesetzt() {
        return besetzt;
    }

    public void setBesetzt(Boolean besetzt) {
        this.besetzt = besetzt;
    }
}
