package com.services.category;

import com.models.Category;
import com.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryByid(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> findAllByCategoryNameContaining(String categoryName, Pageable pageable) {
        return categoryRepository.findAllByCategoryNameContaining(categoryName, pageable);
    }
}
