package com.example.theDoubleTrouble.controller;

import com.example.theDoubleTrouble.entity.Spieler;
import com.example.theDoubleTrouble.entity.Team;
import com.example.theDoubleTrouble.repository.SpielerRepository;
import com.example.theDoubleTrouble.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private SpielerRepository spielerRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/teamA",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Optional<Team> getTeam() {
        Spieler spieler1 = new Spieler(1, "herr", "Schultz", 1l);
        Spieler spieler2 = new Spieler(2, "herr", "mueller", 2l);
        //Team teamA = new Team(1, "TeamA", "haha@gmail.com", 1, 2, "74563255424", "secretPasswort", false);
        //teamRepository.save(teamA);

        return teamRepository.findById(1);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/teams",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void initialisiereTeams(Pageable pageable) {
//        Page<Spieler> spielerPage = spielerRepository.findAll(pageable);
//        List<Integer> spielerIDListe = new ArrayList<>();
//        for(Spieler spieler : spielerPage.getContent()){
//            spielerIDListe.add(spieler.getId());
//            System.out.print(spieler.getId());
//        }
        //TODO: Index neu berechnen, zu kleiner Index von spielerrepository
        Page<Spieler> spielerPage = spielerRepository.findAll(pageable);
        List<Integer> spielerIDListe = new ArrayList<>();
        for(int k = 0 ; k < spielerPage.getSize() ; k++){
            spielerIDListe.add(spielerPage.getContent().get(k).getId());
        }

        for(int i = 1, j = 20; i <=20; i++, j++){

            Integer sid1 = spielerIDListe.get(i);
            Integer sid2 = spielerIDListe.get(j);

//            Integer sid1 = spielerIDListe.get((int) (spielerIDListe.size() * Math.random()));
//            spielerIDListe.remove(sid1);
//            Integer sid2 = spielerIDListe.get((int) (spielerIDListe.size() * Math.random()));
//            spielerIDListe.remove(sid2);

            String teamname = "" + sid1 + "plus" + sid2;
            Team team = new Team(i, teamname, sid1, sid2, false);
            teamRepository.save(team);
        }
    }
    }
