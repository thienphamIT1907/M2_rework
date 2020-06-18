package com.controllers;

import com.models.Category;
import com.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public String showCategoryList(
            @PageableDefault(size = 3) Pageable pageable,
            @RequestParam Optional<String> keyword,
            Model model
            ) {
        Page<Category> categoryPage;
        if(keyword.isPresent()) {
            categoryPage = categoryService.findAllByCategoryNameContaining(keyword.get(), pageable);
            model.addAttribute("keyword", keyword.get());
        } else {
            categoryPage = categoryService.findAll(pageable);
        }
        model.addAttribute("category", categoryPage);
        return "/category/list";
    }

    @GetMapping("/create_category")
    public ModelAndView showCreateCategoryPage() {
        return new ModelAndView("/category/create_category", "category", new Category());
    }

    @PostMapping("/create_category")
    public String createCategory(@ModelAttribute Category category) {
        categoryService.add(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit_category/{id}")
    public ModelAndView showEditPage(@PathVariable Integer id) {
        return new ModelAndView("/category/edit", "category", categoryService.findById(id));
    }

    @PostMapping("/edit_category")
    public String editCategory(Category category, RedirectAttributes redirect) {
        categoryService.add(category);
        redirect.addFlashAttribute("message", "Category updated successfully !");
        return "redirect:/categories";
    }

    @GetMapping("delete_category/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategoryByid(id);
        return "redirect:/categories";
    }
}
