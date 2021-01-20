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
        List<Team> teams = teamRepository.findAll();
        List<Court> courts = courtRepository.findAll();
        List<Spielkarte> spielkarten = spielkarteRepository.findAll();
        Court court = courts.get(0);
        if (court.getBesetzt() != false) {
            for (Court c : courts) {
                if (c.getBesetzt() == false) {
                    court = c;
                }
            }
        }
        court.setBesetzt(true);
        courtRepository.save(court);
        Team team1 = teams.get((int) (Math.random() * teams.size()));
        while(team1.isImSpiel() == true){
            team1 = teams.get((int) (Math.random() * teams.size()));
        }
        team1.setImSpiel(true);
        teamRepository.save(team1);

        Team team2 = teams.get((int) (Math.random() * teams.size()));
        while( team2.isImSpiel() == true || team1.getId() == team2.getId()){
            team2 = teams.get((int) (Math.random() * teams.size()));
        }
        team2.setImSpiel(true);
        teamRepository.save(team2);
        Spielkarte sk1 = spielkarten.get(team1.getId()-1);
        Spielkarte sk2 = spielkarten.get(team2.getId()-1);
        Spiel spiel = new Spiel(spielRepository.findAll(pageable).getContent().size() + 1, SpielModus.ZUFALL, sk1.getId(), sk2.getId(), 1, new Time(10, 30, 0), 0, 0);
        spielRepository.save(spiel);
        return spiel;
    }

    public void punkteEintragen(Integer spielID, Integer punkteTeam1, Integer punkteTeam2) {
        Spiel spiel = spielRepository.getOne(spielID);
        spiel.setTeam1Punkte(punkteTeam1);
        spiel.setTeam2Punkte(punkteTeam2);
    }
}
