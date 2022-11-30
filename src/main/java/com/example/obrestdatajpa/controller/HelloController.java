package com.example.obrestdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/controller")
    public String holaMundo(){
        return "Initializing new restController";
    }

}
