package com.example.demo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidatorImpl.class)
public @interface EmailValidator {
    String message()

    default "Invalid email format!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
