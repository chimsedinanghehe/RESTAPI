package com.example.restapi.repository;

import com.example.restapi.model.Blog;
import com.example.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByAuthor(User author);
}
