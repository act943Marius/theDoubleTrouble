package com.example.theDoubleTrouble.entity;

import javax.persistence.*;

@Entity
@Table(name = "Court")
public class Court {


    @Id
    private Integer courtNummer;
    private Boolean besetzt;

    public Court(Integer courtNummer, Boolean besetzt) {
        this.courtNummer = courtNummer;
        this.besetzt = besetzt;
    }

    public Court() {
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
