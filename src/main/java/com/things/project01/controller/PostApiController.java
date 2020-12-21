package com.things.project01.controller;

import com.things.project01.dto.PostCreatedDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApiController {

    @PostMapping("/post/created")
    public ResponseEntity created(@RequestBody PostCreatedDto createdDto) {
        return ResponseEntity.ok().build();
    }
}
