package com.repository;

import com.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer > {

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
