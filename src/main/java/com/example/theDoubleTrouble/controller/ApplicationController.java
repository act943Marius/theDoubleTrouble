package com.example.theDoubleTrouble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("")
    public String viewHomePage(){
        return "home";
    }

    @GetMapping("httpTest")
    public String viewHttpTestPage(){
        return "httpTest";
    }

    @GetMapping("login")
    public String viewLoginPage(){
        return "login";
    }

    @GetMapping("teamstabelle")
    public String viewTeamstabelle(){
        return "teamstabelle";
    }
}
