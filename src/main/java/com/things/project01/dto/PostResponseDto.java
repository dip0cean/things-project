package com.things.project01.dto;

import com.things.project01.domain.Post;
import lombok.*;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String createdDate;

    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.createdDate = entity.getUpdatedDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }
}
