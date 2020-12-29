package com.things.project01.repository;

import com.things.project01.domain.Post;

public interface PostRepository {
    // 게시글 작성
    Long created(Post post);

    // 게시글 단일 조회
    Post findById(Long id);

    // 게시글 수정
    void update(Post post);

    // 게시글 삭제
    void delete(Long id);
}
