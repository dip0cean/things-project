package com.things.project01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/created")
    public String created() {
        return "created";
    }
}
