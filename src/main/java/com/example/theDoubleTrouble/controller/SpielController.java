package com.example.theDoubleTrouble.controller;

import com.example.theDoubleTrouble.entity.*;
import com.example.theDoubleTrouble.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;

@RestController
public class SpielController {

    @Autowired
    private SpielRepository spielRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CourtRepository courtRepository;

    @Autowired
    SpielplanRepository spielplanRepository;

    @Autowired
    SpielkarteRepository spielkarteRepository;

    @GetMapping("/spiele")
    public Page<Spiel> getSpiele(Pageable pageable) {
        return spielRepository.findAll(pageable);
    }

    @GetMapping("/spiel")
    public Spiel getSpiel(Pageable pageable) {
        return new Spiel(1, SpielModus.ZUFALL, 1, 2, 1, new Time(10, 30, 0), 0, 0);
    }


    private int spielmodus = 0;


    //TODO: Fehlerzuweisungen beheben
    @GetMapping("/createspiel")
    public Spiel createSpiel(Pageable pageable) {
        Page<Team> teams = teamRepository.findAll(pageable);
        Page<Court> courts = courtRepository.findAll(pageable);
        Page<Spielkarte> spielkarten = spielkarteRepository.findAll(pageable);
        Court court = courts.getContent().get(0);
        if (court.getBesetzt() != false) {
            for (Court c : courts.getContent()) {
                if (c.getBesetzt() == false) {
                    court = c;
                }
            }
        }
        court.setBesetzt(true);
        courtRepository.save(court);
        Team team1 = teams.getContent().get((int) (Math.random() * teams.getContent().size()));
        while(team1.isImSpiel() == true){
            team1 = teams.getContent().get((int) (Math.random() * teams.getContent().size()));
        }
        team1.setImSpiel(true);
        teamRepository.save(team1);

        Team team2 = teams.getContent().get((int) (Math.random() * teams.getContent().size()));
        while( team2.isImSpiel() == true || team1.getId() == team2.getId()){
            team2 = teams.getContent().get((int) (Math.random() * teams.getContent().size()));
        }
        team2.setImSpiel(true);
        teamRepository.save(team2);
        Spielkarte sk1 = spielkarten.getContent().get(team1.getId()-1);
        Spielkarte sk2 = spielkarten.getContent().get(team2.getId()-1);
        Spiel spiel = new Spiel(spielRepository.findAll(pageable).getContent().size() + 1, SpielModus.ZUFALL, sk1.getId(), sk2.getId(), court.getId(), new Time(10, 30, 0), 0, 0);
        spielRepository.save(spiel);
        return spiel;
    }

    public void punkteEintragen(Integer spielID, Integer punkteTeam1, Integer punkteTeam2) {
        Spiel spiel = spielRepository.getOne(spielID);
        spiel.setTeam1Punkte(punkteTeam1);
        spiel.setTeam2Punkte(punkteTeam2);
    }
}
