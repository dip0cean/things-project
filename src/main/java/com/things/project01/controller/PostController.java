package com.things.project01.controller;

import com.things.project01.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("post", postService.findAll());
        return "index";
    }

    @GetMapping("/created")
    public String created() {
        return "created";
    }
}
