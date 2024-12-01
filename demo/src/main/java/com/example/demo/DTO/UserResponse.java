package com.example.demo.dto;

import com.example.demo.model.User;

public class UserResponse {
    public Long id;
    public String username;
    public int age;
    public String email;

    public static UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        if (user == null) {
            response.id = (long) -1;
            response.username = "";
            response.age = -1;
            response.email = "";
            return response;
        }
        response.id = user.getUuid();
        response.username = user.getUsername();
        response.age = user.getAge();
        response.email = user.getEmail();
        return response;
    }
}