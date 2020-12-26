package com.things.project01.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable =  false)
    private String title;

    @Column(length = 255, nullable = false)
    private String content;

    @Column(length = 255, nullable = false)
    private String author;

    @Column(nullable = false)
    private int password;

    @Builder
    public Post(Long id, String title, String content, String author, int password) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public void updatePost(String title, String content, String author, int password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }
}
