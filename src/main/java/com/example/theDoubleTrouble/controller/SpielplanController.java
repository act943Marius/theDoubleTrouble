package com.example.theDoubleTrouble.controller;

import com.example.theDoubleTrouble.repository.SpielplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpielplanController {

    @Autowired
    private SpielplanRepository spielplanRepository;

}
