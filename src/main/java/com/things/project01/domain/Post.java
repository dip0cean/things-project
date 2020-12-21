package com.things.project01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable =  false)
    private String title;

    @Column(length = 255, nullable = false)
    private String content;

    @Column(length = 30, nullable = false)
    private String author;

    @Column
    @CreatedDate
    private LocalDateTime createdDate;

    public Post() {
    }
}
