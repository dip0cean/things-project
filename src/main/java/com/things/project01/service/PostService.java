package com.things.project01.service;

import com.things.project01.domain.Post;
import com.things.project01.dto.PostRequestDto;
import com.things.project01.dto.PostResponseDto;

import java.util.List;

public interface PostService {
    // 게시글 작성
    public Post created(PostRequestDto createdDto);
    // 게시글 전체 조회
    public List<PostResponseDto> findAll();
    // 게시글 단일 조회
    public Post findById(Long id);
    // 게시글 비밀번호 확인
    public boolean checkPw(PostRequestDto requestDto);
}
