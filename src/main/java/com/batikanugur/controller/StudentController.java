package com.batikanugur.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http:localhost:8090/api/v1
@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot - Student Controller";
    }

}
