package com.things.project01.repository;

import com.things.project01.domain.Post;

import javax.persistence.EntityManager;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    private EntityManager em;

    public PostRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Post created(Post post) {
        em.persist(post);
        return post;
    }

    @Override
    public List<Post> findAll(int start, int finish) {
        return em.createQuery("select p from Post p", Post.class)
                .getResultList();
    }

    @Override
    public Post modified(Post post) {
        return null;
    }

    @Override
    public Post delete(Post post) {
        return null;
    }
}
