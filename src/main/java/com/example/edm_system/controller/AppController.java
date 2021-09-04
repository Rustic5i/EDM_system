package com.example.edm_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/edm")
public class AppController {
    @GetMapping
    public String index(){
        return "index";
    }
}
