package com.blog.repository.impl;

import com.blog.models.Blog;
import com.blog.repository.BlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("SELECT b FROM Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Integer id) {
        TypedQuery<Blog> query = entityManager.createQuery("SELECT b FROM Blog b WHERE b.id =:id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void add(Blog blog) {
        if(blog.getId() != null) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void deletePost(Integer id) {
        Blog blogForDelete = findById(id);
        if(blogForDelete != null) {
            entityManager.remove(blogForDelete);
        }
    }
}
