package com.example.theDoubleTrouble.controller;

import com.example.theDoubleTrouble.repository.RechnungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RechnungController {

    @Autowired
    private RechnungRepository rechnungRepository;
}
