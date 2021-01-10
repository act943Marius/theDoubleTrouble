package com.example.theDoubleTrouble.controller;

import com.example.theDoubleTrouble.entity.*;
import com.example.theDoubleTrouble.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
    public class SpielController {

        @Autowired
        private SpielRepository spielRepository;


        TeamRepository teamRepository;
        //CourtRepository courtRepository;
        SpielplanRepository spielplanRepository;
        SpielkarteRepository spielkarteRepository;

        @GetMapping("/spiele")
        public Page<Spiel> getSpiele(Pageable pageable) {
            return spielRepository.findAll(pageable);
        }

        private int spielmodus = 0;

    @GetMapping("/createspiel")
   // public Spiel createSpiel(@PathVariable long spielModus){
    public Spiel createSpiel(){
        List<Team> teams = teamRepository.findAll();
        //List<Court> courts = courtRepository.findAll();
        List<Spielplan> spielplans = spielplanRepository.findAll();
        List<Spielkarte> spielkarten = spielkarteRepository.findAll();
        switch (spielmodus) {
            case 0:
                //Court court = courts.get((int)(Math.random() * courts.size()));
                //court.setBesetzt(true);
                Team team1 = teams.get((int)(Math.random() * teams.size()));
                teams.remove(team1);
                Team team2 = teams.get((int)(Math.random() * teams.size()));
                teams.remove(team2);
                Spielkarte sk1 = spielkarten.get(team1.getId());
                Spielkarte sk2 = spielkarten.get(team2.getId());
                //Spielkarte sk1 = new Spielkarte(1, team1.getTeamnamen(), 0, 0d);
                //Spielkarte sk2 = new Spielkarte(2, team2.getTeamnamen(), 0, 0d);
                Spiel spiel = new Spiel(spielplans.size() + 1, SpielModus.ZUFALL, sk1.getId(), sk2.getId(),
                        1, new Time(10,30,0), 0,0);
                return spiel;
        }
        return null;
    }

    public void punkteEintragen(Integer spielID, Integer punkteTeam1, Integer punkteTeam2) {
        Spiel spiel = spielRepository.getOne(spielID);
        spiel.setTeam1Punkte(punkteTeam1);
        spiel.setTeam2Punkte(punkteTeam2);
        }
}
