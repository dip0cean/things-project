package com.things.project01.config;

import com.things.project01.repository.PostRepository;
import com.things.project01.repository.PostRepositoryImpl;
import com.things.project01.service.PostService;
import com.things.project01.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public PostRepository postRepository() {
        return new PostRepositoryImpl(em);
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postRepository());
    }
}
