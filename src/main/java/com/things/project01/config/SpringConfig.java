package com.things.project01.config;

import com.things.project01.repository.PaginationRepository;
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
    private final PaginationRepository paginationRepository;

    @Autowired
    public SpringConfig(EntityManager em, EntityManagerFactory emf, PaginationRepository paginationRepository) {
        this.em = em;
        this.emf = emf;
        this.paginationRepository = paginationRepository;
    }

    @Bean
    public PostRepository postRepository() {
        return new PostRepositoryImpl(em, emf);
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postRepository(),paginationRepository);
    }
}
