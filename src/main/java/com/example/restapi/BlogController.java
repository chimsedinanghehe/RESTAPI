package com.example.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final List<Blog> blogs = new ArrayList<>();

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id) {
        Optional<Blog> blog = blogs.stream().filter(b -> b.getId() == id).findFirst();
        return blog.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createBlog(@RequestBody Blog blog) {
        blogs.add(blog);
        return ResponseEntity.ok("Blog created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBlog(@PathVariable int id, @RequestBody Blog updatedBlog) {
        Optional<Blog> blog = blogs.stream().filter(b -> b.getId() == id).findFirst();
        if (blog.isPresent()) {
            blog.get().setTitle(updatedBlog.getTitle());
            blog.get().setContent(updatedBlog.getContent());
            return ResponseEntity.ok("Blog updated");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable int id) {
        Optional<Blog> blog = blogs.stream().filter(b -> b.getId() == id).findFirst();
        if (blog.isPresent()) {
            blogs.remove(blog.get());
            return ResponseEntity.ok("Blog deleted");
        }
        return ResponseEntity.notFound().build();
    }
}
