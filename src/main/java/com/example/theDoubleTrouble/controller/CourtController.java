package com.example.theDoubleTrouble.controller;

import com.example.theDoubleTrouble.entity.Court;
import com.example.theDoubleTrouble.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CourtController {

    @Autowired
    private CourtRepository courtRepository;



    @GetMapping("/hahaa")
    public Page<Court> getCourt(Pageable pageable) {
        return courtRepository.findAll(pageable);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/haha",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Optional<Court> getCourt() {
        courtRepository.save(new Court(2,false));
        return courtRepository.findById(2);
    }

    //TODO: Automatisch aufrufen bei Programmstart!
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/courts",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void initializeCourts(){
        for(int i = 1; i<=10; i++){
            if(i!=6){
                Court court = new Court(i, false);
                courtRepository.save(court);
            }
        }
    }
}
