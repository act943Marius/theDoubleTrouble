package com.example.theDoubleTrouble.controller;


import com.example.theDoubleTrouble.repository.SpielkarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpielkarteController {

    @Autowired
    private SpielkarteRepository spielkarteRepository;
}
