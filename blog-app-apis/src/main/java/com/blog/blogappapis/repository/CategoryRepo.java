package com.blog.blogappapis.repository;

import com.blog.blogappapis.entity.Category;
import com.blog.blogappapis.payloads.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {


}
