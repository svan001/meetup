package com.svan.veille.bsmt.meetup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/meetup/**")
    public String home() {
        return "forward:/index.html";
    }
}
