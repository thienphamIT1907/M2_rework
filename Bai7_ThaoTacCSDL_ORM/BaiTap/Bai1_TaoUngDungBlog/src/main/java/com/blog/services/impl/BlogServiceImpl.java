package com.blog.services.impl;

import com.blog.models.Blog;
import com.blog.repository.impl.BlogRepositoryImpl;
import com.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepositoryImpl blogRepositoryImp;

    @Override
    public List<Blog> findAll() {
        return blogRepositoryImp.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepositoryImp.findById(id);
    }

    @Override
    public void add(Blog blog) {
        blogRepositoryImp.add(blog);
    }

    @Override
    public void deletePost(Integer id) {
        blogRepositoryImp.deletePost(id);
    }
}
