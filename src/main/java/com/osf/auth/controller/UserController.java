package com.osf.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osf.auth.exception.ResourceNotFoundException;
import com.osf.auth.model.User;
import com.osf.auth.repository.UserRepository;
import com.osf.auth.security.CurrentUser;
import com.osf.auth.security.UserPrincipal;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        //return userRepository.findByEmail(userPrincipal.getEmail())
        //        .orElseThrow(() -> new ResourceNotFoundException("User", "email", userPrincipal.getEmail()));
    	return null;
    }
}
