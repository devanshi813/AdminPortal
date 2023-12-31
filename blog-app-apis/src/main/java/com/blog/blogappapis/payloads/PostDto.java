package com.blog.blogappapis.payloads;

import com.blog.blogappapis.entity.Category;
import com.blog.blogappapis.entity.Comment;
import com.blog.blogappapis.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
    private Set<CommentDto> comments = new HashSet<>();

}
