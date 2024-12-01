package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.validator.EmailValidator;
import com.example.demo.dto.UserResponse;


import jakarta.validation.Valid;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(@Valid User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (!existingUser.isEmpty()) {
            return null;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return UserResponse.toResponse(savedUser);
    }

    public UserResponse updateUserEmail(Long id, @Valid @EmailValidator String email) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isEmpty()) {
            return null;
        }

        User u = existingUser.get();
        u.setEmail(email);
        User savedUser = userRepository.save(u);
        return UserResponse.toResponse(savedUser);
    }

    public UserResponse getUserById(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isEmpty()) {
            return null;
        }

        return UserResponse.toResponse(existingUser.get());
    }

    public boolean logIn(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isEmpty()) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

    public Long authenticate(String username, String rawPassword) {
        Optional<User> savedUser = userRepository.findByUsername(username);
        if (!savedUser.isPresent()) {
            return (long) -1;
        }

        if (!passwordEncoder.matches(rawPassword, savedUser.get().getPassword())) {
            return (long) -1;
        }

        return savedUser.get().getUuid();
    }
}
