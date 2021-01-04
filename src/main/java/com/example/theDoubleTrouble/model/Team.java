package com.example.theDoubleTrouble.model;

public class Team {

    private String teamnamen;
    private String eMailAdresse;
    private Spieler spieler1;
    private Spieler spieler2;
    private String handynummer;
    private String passwort;

    public Team(String teamnamen, String eMailAdresse, Spieler spieler1, Spieler spieler2, String handynummer, String passwort) {
        this.teamnamen = teamnamen;
        this.eMailAdresse = eMailAdresse;
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
        this.handynummer = handynummer;
        this.passwort = passwort;
    }

    public String geteMailAdresse() {
        return eMailAdresse;
    }

    public void seteMailAdresse(String eMailAdresse) {
        this.eMailAdresse = eMailAdresse;
    }

    public Spieler getSpieler1() {
        return spieler1;
    }

    public void setSpieler1(Spieler spieler1) {
        this.spieler1 = spieler1;
    }

    public Spieler getSpieler2() {
        return spieler2;
    }

    public void setSpieler2(Spieler spieler2) {
        this.spieler2 = spieler2;
    }

    public String getHandynummer() {
        return handynummer;
    }

    public void setHandynummer(String handynummer) {
        this.handynummer = handynummer;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getTeamnamen() {
        return teamnamen;
    }

    public void setTeamnamen(String teamnamen) {
        this.teamnamen = teamnamen;
    }


}
