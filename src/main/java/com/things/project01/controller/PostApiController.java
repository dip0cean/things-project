package com.things.project01.controller;

import com.things.project01.dto.PostRequestDto;
import com.things.project01.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostApiController {

    private PostService postService;

    public PostApiController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/api/created")
    public ResponseEntity created(@RequestBody PostRequestDto requestDto) {
        postService.created(requestDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/check")
    public boolean check(@RequestBody PostRequestDto requestDto) {
        boolean check = postService.checkPw(requestDto);
        return check;
    }

    @PutMapping("/api/modified")
    public ResponseEntity modified(@RequestBody PostRequestDto requestDto) {
        return ResponseEntity.ok().build();
    }
}
