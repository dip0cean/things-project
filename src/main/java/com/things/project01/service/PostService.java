package com.things.project01.service;

import com.things.project01.domain.Post;
import com.things.project01.dto.PostRequestDto;
import com.things.project01.dto.PostResponseDto;
import org.springframework.data.domain.Page;

public interface PostService {
    // 게시글 작성
    public Long created(PostRequestDto createdDto);
    // 게시글 전체 조회
    public Page<Post> findAll(int page);
    // 게시글 단일 조회
    public PostResponseDto findById(Long id);
    // 게시글 비밀번호 확인
    public boolean checkPw(PostRequestDto requestDto);
    // 게시글 수정
    public void update(PostRequestDto requestDto);
    // 게시글 삭제
    public void delete(Long id);
}
