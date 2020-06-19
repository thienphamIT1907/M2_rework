package com.services.blog;

import com.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void add(Blog blog);

    void deleteBlogById(Integer id);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByTitleContainingOrContentContainingOrCategory_CategoryNameOrderById(
            String title,
            String content,
            String categoryName,
            Pageable pageable
    );
}
