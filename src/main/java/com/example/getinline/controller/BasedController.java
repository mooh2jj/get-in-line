package com.example.getinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasedController {

    @GetMapping("/")
    public String root() {
        return "index";
    }


}
