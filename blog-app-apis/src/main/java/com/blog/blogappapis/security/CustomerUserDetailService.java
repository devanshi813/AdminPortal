//package com.blog.blogappapis.security;
//
//import com.blog.blogappapis.entity.User;
//import com.blog.blogappapis.exception.ResourceNotFoundException;
//import com.blog.blogappapis.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomerUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private UserRepo userRepo;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//
//        // loading usre from datbase by username
//        User user = this.userRepo.findByEmail(username)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "Email: " + username, 0));
//        return user;
//
//    }
//
//}
