package com.things.project01.repository;

import com.things.project01.domain.Post;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final EntityManager em;

    @Override
    public Long created(Post post) {
        em.persist(post);
        return post.getId();
    }

    @Override
    public Post findById(Long id) {
        return em.find(Post.class, id);
    }

    @Override
    public void update(Post post) {
        Post updatePost = em.find(Post.class, post.getId());
        updatePost.updatePost(post);
    }

    @Override
    public void delete(Long id) {
        Post post = em.find(Post.class, id);
        em.remove(post);
    }
}
