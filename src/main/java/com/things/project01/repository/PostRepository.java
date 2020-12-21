package com.things.project01.repository;

import com.things.project01.domain.Post;
import com.things.project01.dto.PostCreatedDto;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    // 게시글 작성
    public Post created(Post post);

    // 게시글 조회
    public List<Post> findAll(int start, int finish);

    // 게시글 수정
    public Post modified(Post post);

    // 게시글 삭제
    public Post delete(Post post);
}
