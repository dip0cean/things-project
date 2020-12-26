package com.things.project01.dto;

import com.things.project01.domain.Post;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private int password;

    public Post toEntity() {
        return Post.builder()
                .id(getId())
                .title(getTitle())
                .content(getContent())
                .author(getAuthor())
                .password(getPassword())
                .build();
    }
}
