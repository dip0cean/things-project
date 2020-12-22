package com.things.project01.service;

import com.things.project01.domain.Post;
import com.things.project01.dto.PostRequestDto;
import com.things.project01.dto.PostResponseDto;
import com.things.project01.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<PostResponseDto> findAll() {
        return postRepository.findAll().stream()
                .map(post -> new PostResponseDto(post))
                .collect(Collectors.toList());
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public boolean checkPw(PostRequestDto requestDto) {
        Post post = postRepository.findById(requestDto.getId());
        boolean check = post.getPassword().equals(requestDto.getPassword()) ? true : false;
        return check;
    }
}
