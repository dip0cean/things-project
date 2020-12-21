package com.things.project01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PostCreatedDto {
    private String title;
    private String content;
    private String author;
}
