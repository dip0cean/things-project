package com.things.project01.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable =  false)
    private String title;

    @Column(length = 255, nullable = false)
    private String content;

    @Column(length = 30, nullable = false)
    private String author;

    @Column(length = 4, nullable = false)
    private String password;
}
