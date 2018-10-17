package com.icash.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Reference controller", description = "It's used to recommended this app to other user.")
public class ReferenceController {

    @GetMapping("/public/refer/{code}")
    public void processReferenceFriend(@PathVariable String code){

    }
}
