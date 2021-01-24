package com.example.theDoubleTrouble.controller;


import com.example.theDoubleTrouble.entity.Spielkarte;
import com.example.theDoubleTrouble.entity.Team;
import com.example.theDoubleTrouble.repository.SpielkarteRepository;
import com.example.theDoubleTrouble.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpielkarteController {

    @Autowired
    private SpielkarteRepository spielkarteRepository;

    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/spielkarten",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void initialisiereTeams(Pageable pageable) {
        List<Team> teamListe = teamRepository.findAll();
        for(int i = 0; i < teamListe.size(); i++) {
            Integer sid1 = teamListe.get(i).getId();
            Spielkarte spielkarte = new Spielkarte(sid1, teamListe.get(i).getTeamname(), 0, 0);
            spielkarteRepository.save(spielkarte);
        }
        }
    }

