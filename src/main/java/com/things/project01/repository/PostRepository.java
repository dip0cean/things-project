package com.things.project01.repository;

import com.things.project01.domain.Post;
import com.things.project01.dto.PostRequestDto;

import java.util.List;

public interface PostRepository {
    // 게시글 작성
    public void created(Post post);

    // 게시글 전체 조회
    public List<Post> findAll();

    // 게시글 단일 조회
    public Post findById(Long id);

    // 게시글 수정
    public Post modified(Post post);

    // 게시글 삭제
    public Post delete(Post post);
}
