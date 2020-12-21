package com.things.project01.service;

import com.things.project01.domain.Post;
import com.things.project01.dto.PostRequestDto;

public interface PostService {
    public Post created(PostRequestDto createdDto);
}
