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
    public void created(Post post) {
        em.persist(post);
    }

    @Override
    public List<Post> findAll() {
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
