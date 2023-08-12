package com.blog.blogappapis.payloads;


import com.blog.blogappapis.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private long id;

    @NotEmpty
    @Size(min = 2, message = " Username must be greater than 4")
    private String name;

    @NotNull
    private String about;

    private String email;

    @NotNull
    @Size(min = 3, max=10, message="size must be in between 3 and 10")
    private String password;


    private Set<RoleDto> roles = new HashSet<>();

}
