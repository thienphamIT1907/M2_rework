package com.services.impl;

import com.models.Blog;
import com.repository.impl.BlogRepositoryImpl;
import com.services.BlogService;
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
