package com.things.project01.service;

import com.things.project01.domain.Post;
import com.things.project01.dto.PostRequestDto;
import com.things.project01.repository.PostRepository;

import javax.transaction.Transactional;

@Transactional
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post created(PostRequestDto createdDto) {
        postRepository.created(createdDto.toEntity());
        return createdDto.toEntity();
    }
}
