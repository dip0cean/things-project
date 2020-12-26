package com.things.project01.repository;

import com.things.project01.domain.Post;

public interface PostRepository {
    // 게시글 작성
    public void created(Post post);

    // 게시글 단일 조회
    public Post findById(Long id);

    // 게시글 수정
    public void update(Post post);

    // 게시글 삭제
    public void delete(Long id);
}
