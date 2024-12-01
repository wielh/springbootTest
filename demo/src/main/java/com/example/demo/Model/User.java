package com.example.demo.model;

import com.example.demo.validator.EmailValidator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @Getter
    @Setter
    // @Column(nullable = false, name = "username")
    @NotNull(message = "username cannot be null")
    @Size(min = 5, max = 30, message = "Username must be between 5 and 30 characters")
    private String username;

    @Getter
    @Setter
    @Column(nullable = false)
    @NotNull(message = "Password cannot be null")
    @Size(min = 5, max = 100, message = "Password must be between 5 and 100 characters")
    private String password;

    @Getter
    @Setter
    @Column(nullable = false)
    @Min(value = 0, message = "Age must be greater than or equal to 0")
    @Max(value = 150, message = "Age must be less than or equal to 150")
    @NotNull(message = "Age cannot be null")
    private Integer age;

    @Getter
    @Setter
    @Column(nullable = false)
    @EmailValidator()
    @NotNull(message = "Email cannot be null")
    private String email;
}
