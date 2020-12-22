package com.things.project01.repository;

import com.things.project01.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private EntityManagerFactory emf;
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
    public Post findById(Long id) {
        return em.find(Post.class, id);
    }

    @Override
    public void update(Post post) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Post changePost = em.find(Post.class, post.getId());
        changePost.setTitle(post.getTitle());
        changePost.setContent(post.getContent());
        changePost.setAuthor(post.getAuthor());
        changePost.setPassword(post.getPassword());
        tx.commit();
    }

    @Override
    public Post delete(Post post) {
        return null;
    }
}
