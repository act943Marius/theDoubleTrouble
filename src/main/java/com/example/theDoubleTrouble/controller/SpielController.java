package com.example.theDoubleTrouble.controller;

import com.example.theDoubleTrouble.entity.*;
import com.example.theDoubleTrouble.exception.ResourceNotFoundException;
import com.example.theDoubleTrouble.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/createspiel")
    public Spiel createSpielSchweizerSystem(Pageable pageable) {

        return null;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/alleSpiele",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Spiel> getAllSpiele() {
        return spielRepository.findAll();
    }

    @GetMapping("/spiel/{spielID}")
    public Spiel getSpiel(@PathVariable Integer spielID) {
        Optional<Spiel> spiel = spielRepository.findById(spielID);

        if (!spiel.isPresent())
            throw new ResourceNotFoundException("Course not found with id " + spielID);
        return spiel.get();
    }


    @GetMapping("/createspielZufall")
    public String createSpielZufall(Pageable pageable) {
        List<Team> teams = teamRepository.findAll();
        List<Court> courts = courtRepository.findAll();
        List<Spielkarte> spielkarten = spielkarteRepository.findAll();
        int courtid = courts.size();
        Time zeit = new Time(9, 0, 0);
        int anzahlSpiele = (int) (teams.size() / 2);
        long viertelStunde = (60000 * 30);

        while (anzahlSpiele > 0) {
            anzahlSpiele--;
            if (courtid > 0) {
                courtid--;

            } else {
                courtid = courts.size() - 1;
                zeit.setTime(zeit.getTime() + viertelStunde);
            }

            Court court = courts.get(courtid);
            courtRepository.save(court);

            Team team1 = teams.get((int) (Math.random() * teams.size()));
            while (team1.isImSpiel() == true) {
                team1 = teams.get((int) (Math.random() * teams.size()));
            }
            team1.setImSpiel(true);
            teamRepository.save(team1);

            Team team2 = teams.get((int) (Math.random() * teams.size()));
            while (team2.isImSpiel() == true || team1.getId() == team2.getId()) {
                team2 = teams.get((int) (Math.random() * teams.size()));
            }
            team2.setImSpiel(true);
            teamRepository.save(team2);
            Spielkarte sk1 = spielkarten.get(team1.getId() - 1);
            Spielkarte sk2 = spielkarten.get(team2.getId() - 1);
            Integer spielID = spielRepository.findAll().size() + 1;
            Spiel spiel = new Spiel(spielID, SpielModus.ZUFALL, sk1.getId(), sk2.getId(), team1.getTeamname(), team2.getTeamname(), court.getCourtNummer(), zeit, 0, 0);
            spielRepository.save(spiel);
        }
        return "Spiele wurden erstellt.";
    }


    @PutMapping("/spiel/{spielID}")
    public Spiel updateSpiel(@PathVariable Integer spielID,
                               @Valid @RequestBody Spiel spielRequest) {
        return spielRepository.findById(spielID)
                .map(spiel -> {
                    spiel.setTeam1Punkte(spielRequest.getTeam1Punkte());
                    spiel.setTeam2Punkte(spielRequest.getTeam2Punkte());
                    return spielRepository.save(spiel);
                }).orElseThrow(() -> new ResourceNotFoundException("Spiel not found with id " + spielID));
    }
}
