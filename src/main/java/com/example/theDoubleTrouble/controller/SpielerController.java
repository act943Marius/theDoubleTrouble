package com.example.theDoubleTrouble.controller;

import com.example.theDoubleTrouble.entity.Spieler;
import com.example.theDoubleTrouble.repository.SpielerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SpielerController {

    @Autowired
    private SpielerRepository spielerRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/spieler1",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Optional<Spieler> getSpieler() {
        Spieler spieler1 = new Spieler(1, "herr", "Schultz", 190946436l);
        spielerRepository.save(spieler1);

        return spielerRepository.findById(1);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/spieler",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void initialisiereSpieler() {
        for(int i = 1; i <=40; i++){
            int id = i;
            String vorname = "vorname" + i;
            String nachname = "nachname" + i;
            long telenr = (long)(100000000 * Math.random());
            Spieler spieler = new Spieler(id, vorname, nachname, telenr);
            spielerRepository.save(spieler);
        }
    }
}
