package com.blog.services;


import com.blog.models.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> findAll();

    Blog findById(Integer id);

    void add(Blog blog);

    void deletePost(Integer id);
}
