package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.UserResponse;
import com.example.demo.service.UserService;
import com.example.demo.config.Utils;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import jakarta.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello, Spring Boot!");
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpSession session) {
        Long uuid = userService.authenticate(user.getUsername(), user.getPassword());
        if (uuid >= 0) {
            Utils.setSessionUUID(session, uuid);
            Utils.setSessionUsername(session, user.getUsername());
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PatchMapping("/user")
    public ResponseEntity<UserResponse> updateUserPartially(@RequestBody User user, HttpSession session) {
        Long userId = Utils.getSessionUUID(session);
        return ResponseEntity.ok(userService.updateUserEmail(userId, user.getEmail()));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }

}