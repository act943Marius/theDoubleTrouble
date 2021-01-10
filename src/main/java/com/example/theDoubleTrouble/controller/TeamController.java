package com.example.theDoubleTrouble.controller;

import com.example.theDoubleTrouble.entity.Spieler;
import com.example.theDoubleTrouble.entity.Team;
import com.example.theDoubleTrouble.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/teamA",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Team getTeam() {
        Spieler spieler1 = new Spieler("herr", "Schultz", new Date(2020, 5, 15), 1);
        Spieler spieler2 = new Spieler("herr", "mueller", new Date(2020, 5, 15), 2);
        Team teamA = new Team("TeamA", "haha@gmail.com", spieler1.getId(), spieler2.getId(), "74563255424", "secretPasswort");
        //return teamA;

        return teamRepository.getOne(1);
    }
//
//    @GetMapping("/courses/{courseId}/students")
//    public List<Student> getStudentsByCourseId(@PathVariable Long courseId) {
//        return studentRepository.findByCourseId(courseId);
//    }
//
//    @RequestMapping(
//            method = RequestMethod.GET,
//            path = "/teamA",
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//        public List<Student> getStudentsByCourseId (@PathVariable Long courseId){
//            return studentRepository.findByCourseId(courseId);
//        }

    }
