package com.example.restapi.controller;

import com.example.restapi.model.Blog;
import com.example.restapi.model.User;
import com.example.restapi.repository.BlogRepository;
import com.example.restapi.repository.UserRepository;
import com.example.restapi.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {


    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    private String extractToken(String header) {
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7); // bỏ "Bearer "
        }
        throw new RuntimeException("Invalid Authorization header");
    }

    private String getUsername(String token) {
        return jwtUtils.getUsernameFromJwt(token);
    }

    private boolean isAdmin(String token) {
        return jwtUtils.getRoleFromJwt(token).equals("ADMIN");
    }

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @PostMapping
    public Blog createBlog(@RequestHeader("Authorization") String header,
                           @RequestBody Blog blog) {
        String token = extractToken(header);
        String username = getUsername(token);
        User user = userRepository.findByUsername(username).orElseThrow();
        blog.setAuthor(user);
        return blogRepository.save(blog);
    }

    @PutMapping("/{id}")
    public Blog updateBlog(@RequestHeader("Authorization") String header,
                           @PathVariable Long id,
                           @RequestBody Blog blogDetails) {
        String token = extractToken(header);
        Blog blog = blogRepository.findById(id).orElseThrow();
        String username = getUsername(token);

        if (!isAdmin(token) && !blog.getAuthor().getUsername().equals(username)) {
            throw new RuntimeException("Access denied");
        }

        blog.setTitle(blogDetails.getTitle());
        blog.setContent(blogDetails.getContent());
        return blogRepository.save(blog);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@RequestHeader("Authorization") String header,
                           @PathVariable Long id) {
        String token = extractToken(header);
        if (!isAdmin(token)) throw new RuntimeException("Access denied");
        blogRepository.deleteById(id);
    }

}
