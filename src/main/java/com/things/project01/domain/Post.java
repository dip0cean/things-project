package com.things.project01.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Post extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",length = 255, nullable =  false)
    private String title;

    @Column(name = "content" ,length = 255, nullable = false)
    private String content;

    @Column(name = "author",length = 30, nullable = false)
    private String author;

    @Column(length = 4, nullable = false)
    private String password;

    public Post() {
    }
}
