package com.things.project01.dto;

import com.things.project01.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;

    public Post toEntity() {
        return Post.builder().title(getTitle()).content(getContent()).author(getAuthor()).password(getPassword()).build();
    }
}
