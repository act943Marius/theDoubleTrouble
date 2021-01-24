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
    public void initialisiereTeams(Pageable pageable) {
//        Page<Spieler> spielerPage = spielerRepository.findAll(pageable);
//        List<Integer> spielerIDListe = new ArrayList<>();
//        for(Spieler spieler : spielerPage.getContent()){
//            spielerIDListe.add(spieler.getId());
//            System.out.print(spieler.getId());
//        }
        //TODO: Index neu berechnen, zu kleiner Index von spielerrepository
        Page<Spieler> spielerPage = spielerRepository.findAll(pageable);
        List<Spieler> spielerListe = spielerRepository.findAll();
       //List<Integer> spielerIDListe = new ArrayList<>();
//        for(int k = 0 ; k < 10 ; k++){
//            spielerIDListe.add(spielerPage.getContent().get(k).getId());
//        }

        for(int i = 0, j = spielerListe.size() - 1; i < j; i++, j--) {

//            Integer sid1 = spielerPage.getContent().get(i).getId();
//            Integer sid2 = spielerPage.getContent().get(j).getId();

            Integer sid1 = spielerListe.get(i).getId();
            Integer sid2 = spielerListe.get(j).getId();

//          Integer sid1 = spielerListe.get((int) (spielerListe.size() * Math.random())).getId();
//           spielerListe.remove(sid1);
//            Integer sid2 = spielerListe.get((int) (spielerListe.size() * Math.random())).getId();
//           spielerListe.remove(sid2);

            String teamname = "" + sid1 + "plus" + sid2;
            Team team = new Team(i+1, teamname, sid1, sid2, false);
            teamRepository.save(team);
        }
        //return "SpielerListe größe: " + spielerListe.size() + "  spielerPage größe: " + spielerPage.getSize() + "   getContent größe: " + spielerPage.getContent().size()+ "    spielerPage.getNumberofElements größe: " + spielerPage.getNumberOfElements();
    }
    }
