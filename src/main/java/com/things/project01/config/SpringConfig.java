package com.things.project01.config;

import com.things.project01.repository.PostRepository;
import com.things.project01.repository.PostRepositoryImpl;
import com.things.project01.service.PostService;
import com.things.project01.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
public class SpringConfig {

    private EntityManager em;
    private EntityManagerFactory emf;

    @Autowired
    public SpringConfig(EntityManager em, EntityManagerFactory emf) {
        this.em = em;
        this.emf = emf;
    }

    @Bean
    public PostRepository postRepository() {
        return new PostRepositoryImpl(em, emf);
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postRepository());
    }
}
