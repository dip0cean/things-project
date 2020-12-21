package com.things.project01.controller;

import com.things.project01.dto.PostRequestDto;
import com.things.project01.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostApiController {

    private PostService postService;

    public PostApiController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/api/created")
    public ResponseEntity created(@RequestBody PostRequestDto createdDto) {
        postService.created(createdDto);
        return ResponseEntity.ok().build();
    }
}
