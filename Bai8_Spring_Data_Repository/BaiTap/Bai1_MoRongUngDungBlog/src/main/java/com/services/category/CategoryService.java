package com.services.category;

import com.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Category findById(Integer id);

    void add(Category category);

    void deleteCategoryByid(Integer id);

    Page<Category> findAllByCategoryNameContaining(String categoryName, Pageable pageable);
}
