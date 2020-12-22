package com.things.project01.service;

import com.things.project01.domain.Post;
import com.things.project01.dto.PostRequestDto;
import com.things.project01.dto.PostResponseDto;

import java.util.List;

public interface PostService {
    public Post created(PostRequestDto createdDto);
    public List<PostResponseDto> findAll();
}
