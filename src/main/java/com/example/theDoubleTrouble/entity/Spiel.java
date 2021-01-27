package com.example.theDoubleTrouble.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;

@Entity
@Table
public class Spiel {

    @Id
    private Integer id;

    private SpielModus spielModus;
    private Integer spielkarteTeam1Id;
    private Integer spielkarteTeam2Id;
    private String teamname1;
    private String teamname2;
    private Integer courtID;
    private Time spielzeit;
    private Integer team1Punkte;
    private Integer team2Punkte;

    public Spiel() {
    }

    public Spiel(Integer id, SpielModus spielModus, Integer spielkarteTeam1Id,
                 Integer spielkarteTeam2Id, String teamname1, String teamname2, Integer courtID, Time spielzeit,
                 Integer team1Punkte, Integer team2Punkte) {
        this.id = id;
        this.spielModus = spielModus;
        this.spielkarteTeam1Id = spielkarteTeam1Id;
        this.spielkarteTeam2Id = spielkarteTeam2Id;
        this.teamname1 = teamname1;
        this.teamname2 = teamname2;
        this.courtID = courtID;
        this.spielzeit = spielzeit;
        this.team1Punkte = team1Punkte;
        this.team2Punkte = team2Punkte;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public SpielModus getSpielModus() {
        return spielModus;
    }

    public void setSpielModus(SpielModus spielModus) {
        this.spielModus = spielModus;
    }

    public Integer getSpielkarteTeam1Id() {
        return spielkarteTeam1Id;
    }

    public void setSpielkarteTeam1Id(Integer spielkarteTeam1Id) {
        this.spielkarteTeam1Id = spielkarteTeam1Id;
    }

    public Integer getSpielkarteTeam2Id() {
        return spielkarteTeam2Id;
    }

    public void setSpielkarteTeam2Id(Integer spielkarteTeam2Id) {
        this.spielkarteTeam2Id = spielkarteTeam2Id;
    }

    public Integer getCourtID() {
        return courtID;
    }

    public void setCourtID(Integer courtID) {
        this.courtID = courtID;
    }

    public Time getSpielzeit() {
        return spielzeit;
    }

    public void setSpielzeit(Time spielzeit) {
        this.spielzeit = spielzeit;
    }

    public Integer getTeam1Punkte() {
        return team1Punkte;
    }

    public void setTeam1Punkte(Integer team1Punkte) {
        this.team1Punkte = team1Punkte;
    }

    public String getTeamname1() {
        return teamname1;
    }

    public void setTeamname1(String teamname1) {
        this.teamname1 = teamname1;
    }

    public String getTeamname2() {
        return teamname2;
    }

    public void setTeamname2(String teamname2) {
        this.teamname2 = teamname2;
    }

    public Integer getTeam2Punkte() {
        return team2Punkte;
    }

    public void setTeam2Punkte(Integer team2Punkte) {
        this.team2Punkte = team2Punkte;
    }
}
