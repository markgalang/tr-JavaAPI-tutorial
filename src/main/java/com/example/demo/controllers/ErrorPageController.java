package com.example.demo.controllers;

import com.example.demo.pojo.ApiResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageController implements ErrorController {
    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @GetMapping(PATH)
    public ResponseEntity api404page(){
        return ResponseEntity.status(404).body(ApiResponse.builder()
                .code(404).status("NOT FOUND").message("thiis page doesn\'t exist").build());
    }

}
