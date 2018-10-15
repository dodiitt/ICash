package com.icash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/public/test")
    public String test(){
        return "ICash is setting up!.";
    }
    @GetMapping("/protected/test")
    public String test1(){
        return "ICash is setting up!.";
    }
}
