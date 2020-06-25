package com.controllers;

import com.models.Blog;
import com.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView showHomePage() {
        return new ModelAndView("home", "blog", blogService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("create", "blog", new Blog());
    }

    @PostMapping("/create")
    public String addNewBlog(Blog blog, RedirectAttributes redirect) {
        blogService.add(blog);
        redirect.addFlashAttribute("message","Create new Blog success !");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewBlog(@PathVariable Integer id) {
       return new ModelAndView("view", "blog", blogService.findById(id));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable Integer id) {
        return new ModelAndView("edit", "blog", blogService.findById(id));
    }

    @PostMapping("/edit")
    public String editBlog(Blog blog, RedirectAttributes redirect) {
        blogService.add(blog);
        redirect.addFlashAttribute("message", "Customer updated successfully");
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteBlog(@PathVariable int id, RedirectAttributes redirect) {
        blogService.deletePost(blogService.findById(id).getId());
        return "redirect:/";
    }
}