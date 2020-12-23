package com.things.project01.service;

import com.things.project01.domain.Post;
import com.things.project01.dto.PostRequestDto;
import com.things.project01.dto.PostResponseDto;
import com.things.project01.repository.PostRepository;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostResponseDto created(PostRequestDto createdDto) {
        postRepository.created(createdDto.toEntity());
        return new PostResponseDto(createdDto.toEntity());
    }

    @Override
    public List<PostResponseDto> findAll() {
        return postRepository.findAll().stream()
                .map(post -> new PostResponseDto(post))
                .collect(Collectors.toList());
    }

    @Override
    public PostResponseDto findById(Long id) {
        return new PostResponseDto(postRepository.findById(id));
    }

    @Override
    public boolean checkPw(PostRequestDto requestDto) {
        Post post = postRepository.findById(requestDto.getId());
        boolean check = post.getPassword().equals(requestDto.getPassword()) ? true : false;
        return check;
    }

    @Override
    public void update(PostRequestDto requestDto) {
        Post post = requestDto.toEntity();
        postRepository.update(post);
    }

    @Override
    public void delete(Long id) {
        postRepository.delete(id);
    }
}
