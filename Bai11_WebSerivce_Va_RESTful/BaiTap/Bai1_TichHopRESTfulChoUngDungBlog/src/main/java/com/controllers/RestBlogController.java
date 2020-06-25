package com.controllers;

import com.models.Blog;
import com.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestBlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getListBlog() {
        List<Blog> studentList = blogService.findAll();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog) {
        blogService.add(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/blog/{id}")
    public ResponseEntity<List<Blog>> deleteblog(@PathVariable Integer id) {
        blogService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/blog/{id}")
    public ResponseEntity<List<Blog>> updateBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        Blog blogNeedUpdate = blogService.findById(id);
        if (blogNeedUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogNeedUpdate.setId(blog.getId());
        blogNeedUpdate.setTitle(blog.getTitle());
        blogNeedUpdate.setContent(blog.getContent());

        blogService.add(blog);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
