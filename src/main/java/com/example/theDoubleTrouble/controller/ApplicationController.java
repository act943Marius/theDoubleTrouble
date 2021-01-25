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

    @GetMapping("httpTestPost")
    public String viewHttpTestPostPage(){
        return "httpTestPost";
    }

    @GetMapping("login")
    public String viewLoginPage(){
        return "login";
    }

    @GetMapping("registrieren")
    public String viewRegistrierungspage(){
        return "registrieren";
    }

    @GetMapping("teamstabelle")
    public String viewTeamstabellenPage(){
        return "teamstabelle";
    }
}
