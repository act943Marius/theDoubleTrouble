package com.example.theDoubleTrouble.controller;

import com.example.theDoubleTrouble.entity.Spieler;
import com.example.theDoubleTrouble.entity.Team;
import com.example.theDoubleTrouble.repository.SpielerRepository;
import com.example.theDoubleTrouble.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return teamRepository.findById(1);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/alleteams",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/teamname",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getTeamname() {
        return teamRepository.findById(1).get().getTeamname();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/teams",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void initialisiereTeams() {
        List<Spieler> spielerListe = spielerRepository.findAll();

        for(int i = 0, j = spielerListe.size() - 1; i < j; i++, j--) {
            Integer sid1 = spielerListe.get(i).getId();
            Integer sid2 = spielerListe.get(j).getId();
            String name1 = spielerListe.get(i).getVorname() + " " + spielerListe.get(i).getNachname();
            String name2 = spielerListe.get(j).getVorname() + " " + spielerListe.get(j).getNachname();

            String teamname = "" + sid1 + "plus" + sid2;
            Team team = new Team(i+1, teamname, sid1, sid2, name1, name2, false, "eMailAdresse");
            teamRepository.save(team);
        }
    }

    @PostMapping("/teams")
    public Team createTeam(@Valid @RequestBody Team team) {
        return teamRepository.save(team);
    }

    }
