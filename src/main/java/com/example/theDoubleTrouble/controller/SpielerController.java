package com.example.theDoubleTrouble.controller;

import com.example.theDoubleTrouble.repository.SpielerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpielerController {

    @Autowired
    private SpielerRepository spielerRepository;
}
