package com.example.demo.mysite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstAPI {

    @GetMapping("/")
    public String magePage(){
        return  "hello spring";
    }

    @GetMapping("/hello")
    public  String secondPage(){
        return  "Hello User";
    }
}
