package com.example.theDoubleTrouble.controller;


import com.example.theDoubleTrouble.model.Spieler;
import com.example.theDoubleTrouble.model.Team;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class TeamController {

    @RequestMapping(
        method = RequestMethod.GET,
        path = "/teamA",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Team getTeam(){
        Spieler spieler1 = new Spieler("herr", "Schultz", new Date(2020, 5, 15));
        Spieler spieler2 = new Spieler("herr", "mueller", new Date(2020, 5, 15));
        Team teamA = new Team("TeamA", "haha@gmail.com", spieler1, spieler2, "74563255424", "secretPasswort");
        return teamA;
    }

}
