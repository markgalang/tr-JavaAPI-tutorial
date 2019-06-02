package com.example.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/docs")
@Controller
public class DocV1Controller {

    @GetMapping
    public String apiV1Docs(){
        return "/index.html";
    }
}
