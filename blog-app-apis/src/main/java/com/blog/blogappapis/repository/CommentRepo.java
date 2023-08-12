package com.blog.blogappapis.repository;

import com.blog.blogappapis.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
