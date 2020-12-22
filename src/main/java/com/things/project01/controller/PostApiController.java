package com.things.project01.controller;

import com.things.project01.dto.PostRequestDto;
import com.things.project01.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostApiController {

    private final PostService postService;

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

    @PutMapping("/api/update")
    public ResponseEntity update(@RequestBody PostRequestDto requestDto) {
        postService.update(requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok().build();
    }
}
