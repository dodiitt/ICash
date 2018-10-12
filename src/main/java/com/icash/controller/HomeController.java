package com.icash.controller;

import com.icash.utils.ApplicationInstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = {ApplicationInstant.HOME_URL, "/"}, method = RequestMethod.GET)
    public String homePage(){
        return ApplicationInstant.HOME_HTML;
    }
}
