package com.example.theDoubleTrouble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("Test")
    public String viewTestPage(){
        return "test";
    }

    @GetMapping("httpTest")
    public String viewHttpTestPage(){
        return "httpTest";
    }

    @GetMapping("httpTestPost")
    public String viewHttpTestPostPage(){
        return "httpTestPost";
    }

    @GetMapping("")
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

    @GetMapping("admin")
    public String viewAdminPage(){
        return "admin";
    }

    @GetMapping("spielPlan")
    public String viewSpielplanPage(){
        return "spielPlan";
    }

    @GetMapping("homepage")
    public String viewHomePage(){
        return "homepage";
    }

}
