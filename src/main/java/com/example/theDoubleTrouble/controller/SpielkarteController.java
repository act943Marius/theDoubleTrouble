package com.example.theDoubleTrouble.controller;


import com.example.theDoubleTrouble.entity.Spielkarte;
import com.example.theDoubleTrouble.entity.Team;
import com.example.theDoubleTrouble.exception.ResourceNotFoundException;
import com.example.theDoubleTrouble.repository.SpielkarteRepository;
import com.example.theDoubleTrouble.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class SpielkarteController {

    @Autowired
    private SpielkarteRepository spielkarteRepository;

    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/alleSpielkarten",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Spielkarte> getAllSpielkarten() {
        return spielkarteRepository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/spielkarten",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void initialisiereSpielkarten() {
        List<Team> teamListe = teamRepository.findAll();
        for(int i = 0; i < teamListe.size(); i++) {
            Integer sid1 = teamListe.get(i).getId();
            Spielkarte spielkarte = new Spielkarte(sid1, teamListe.get(i).getTeamname(), 0, 0);
            spielkarteRepository.save(spielkarte);
        }
        }

    @GetMapping("/spielkarte/{spielkartenID}")
    public Spielkarte getSpielkarte(@PathVariable Integer spielkartenID) {
        Optional<Spielkarte> spielkarte = spielkarteRepository.findById(spielkartenID);

        if (!spielkarte.isPresent())
            throw new ResourceNotFoundException("Course not found with id " + spielkartenID);
        return spielkarte.get();
    }

    @PutMapping("/spielkarte/{spielkartenID}")
    public Spielkarte updateSpielkarte(@PathVariable Integer spielkartenID,
                             @Valid @RequestBody Spielkarte spielkartenRequest) {
        return spielkarteRepository.findById(spielkartenID)
                .map(spielkarte -> {
                    spielkarte.setAnzahlSiege(spielkartenRequest.getAnzahlSiege());
                    spielkarte.setPunkteDifferenz(spielkartenRequest.getPunkteDifferenz());
                    return spielkarteRepository.save(spielkarte);
                }).orElseThrow(() -> new ResourceNotFoundException("Spiel not found with id " + spielkartenID));
    }
    }

