package com.blog.blogappapis.service;

import com.blog.blogappapis.payloads.CommentDto;
import lombok.Setter;
import org.springframework.stereotype.Service;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);
}
