package com.things.project01.repository;

import com.things.project01.domain.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public PostRepositoryImpl(EntityManager em, EntityManagerFactory emf) {
        this.em = em;
        this.emf = emf;
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
    public Post findById(Long id) {
        return em.find(Post.class, id);
    }

    @Override
    public void update(Post post) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Post updatePost = em.find(Post.class, post.getId());
        updatePost.updatePost(post.getTitle(), post.getContent(), post.getAuthor(), post.getPassword());
        tx.commit();
    }

    @Override
    public void delete(Long id) {
        Post post = em.find(Post.class, id);
        em.remove(post);
    }
}
