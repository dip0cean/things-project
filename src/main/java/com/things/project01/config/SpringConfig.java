package com.things.project01.config;

import com.things.project01.repository.PaginationRepository;
import com.things.project01.repository.PostRepository;
import com.things.project01.repository.PostRepositoryImpl;
import com.things.project01.service.PostService;
import com.things.project01.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
@RequiredArgsConstructor
public class SpringConfig {

    private final EntityManager em;
    private final PaginationRepository paginationRepository;

    @Bean
    public PostRepository postRepository() {
        return new PostRepositoryImpl(em);
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postRepository(),paginationRepository);
    }
}
