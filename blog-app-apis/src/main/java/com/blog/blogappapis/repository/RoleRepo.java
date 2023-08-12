package com.blog.blogappapis.repository;

import com.blog.blogappapis.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
