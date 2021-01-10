package com.example.theDoubleTrouble.controller;

import com.example.theDoubleTrouble.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourtController {

    @Autowired
    private CourtRepository courtRepository;
}
