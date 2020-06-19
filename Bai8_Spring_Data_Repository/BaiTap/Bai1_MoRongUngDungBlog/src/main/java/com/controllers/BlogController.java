package com.controllers;

import com.models.Blog;
import com.models.Category;
import com.services.blog.BlogService;
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
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String showHomePage() {
        return "/common/menu";
    }

    @GetMapping("/blogs")
    public String showBlogsList(
            @PageableDefault(size = 3) Pageable pageable,
            @RequestParam Optional<String> keyword,
            Model model
    ) {
        Page<Blog> blogPage;
        if (keyword.isPresent()) {
            blogPage = blogService.findAllByTitleContainingOrContentContainingOrCategory_CategoryNameOrderById(
                            keyword.get(),
                            keyword.get(),
                            keyword.get(),
                            pageable
                    );
            model.addAttribute("keyword", keyword.get());
        } else {
            blogPage = blogService.findAll(pageable);
        }
        model.addAttribute("blog", blogPage);
        return "/blog/list";
    }

    @GetMapping("/create_blog")
    public ModelAndView showCreatePage() {
        return new ModelAndView("/blog/create_blog", "blog", new Blog());
    }

    @PostMapping("/create_blog")
    public String addNewBlog(Blog blog, RedirectAttributes redirect) {
        blogService.add(blog);
        redirect.addFlashAttribute("message", "Create new Blog success !");
        return "redirect:/blogs";
    }

    @GetMapping("/view_blog/{id}")
    public ModelAndView viewBlog(@PathVariable Integer id) {
        return new ModelAndView("/blog/view", "blog", blogService.findById(id));
    }

    @GetMapping("/edit_blog/{id}")
    public ModelAndView showEditPage(@PathVariable Integer id) {
        return new ModelAndView("/blog/edit", "blog", blogService.findById(id));
    }

    @PostMapping("/edit_blog")
    public String editBlog(Blog blog, RedirectAttributes redirect) {
        blogService.add(blog);
        redirect.addFlashAttribute("message", "Customer updated successfully");
        return "redirect:/blogs";
    }

    @GetMapping("delete_blog/{id}")
    public String deleteBlog(@PathVariable int id) {
        blogService.deleteBlogById(id);
        return "redirect:/blogs";
    }

    @ModelAttribute("categories")
    public Iterable<Category> showAllCategories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }
}