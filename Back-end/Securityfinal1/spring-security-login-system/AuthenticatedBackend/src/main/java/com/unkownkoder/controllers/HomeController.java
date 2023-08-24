package com.unkownkoder.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "this is home";
    }
    @GetMapping("/admin")
    public String admin(){
        return "this is admin";
    }
}
