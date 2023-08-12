package com.blog.blogappapis.service.Impl;

import com.blog.blogappapis.config.AppConstants;
import com.blog.blogappapis.entity.Role;
import com.blog.blogappapis.payloads.UserDto;
import com.blog.blogappapis.exception.ResourceNotFoundException;
import com.blog.blogappapis.repository.RoleRepo;
import com.blog.blogappapis.repository.UserRepo;
import com.blog.blogappapis.entity.User;
import com.blog.blogappapis.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Override
//    public UserDto registerNewUser(UserDto userDto) {
//
//        User user = this.modelMapper.map(userDto, User.class);
//
//        // encoded the password
//        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
//
//        // roles
//        Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
//
//        user.getRoles().add(role);
//
//        User newUser = this.userRepo.save(user);
//
//        return this.modelMapper.map(newUser, UserDto.class);
//    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(user.getPassword());
        user.setAbout(user.getAbout());

        User updatedUser = this.userRepo.save(user);

        UserDto userDto1 = this.userToDto(updatedUser);

        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user =  this.userRepo.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(user);
    }

    public User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setName(userDto.getName());
//        user.setAbout(userDto.getAbout());

        return user;
    }

    public UserDto userToDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
//        userDto.setId(user.getId());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setName(user.getName());
//        userDto.setAbout(user.getAbout());

        return userDto;
    }
}
