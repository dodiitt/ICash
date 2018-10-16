package com.icash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReferenceController {

    @GetMapping("/public/refer/{code}")
    public void processReferenceFriend(@PathVariable String code){

    }
}
