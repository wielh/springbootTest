package com.example.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidatorImpl implements ConstraintValidator<EmailValidator, String> {

    public EmailValidatorImpl() {
    }

    @Override
    public void initialize(EmailValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String[] emailSplit = value.split("@");
        if (emailSplit.length != 2) {
            return false;
        }

        String[] secondPart = emailSplit[1].split("\\.");
        if (secondPart.length < 2) {
            return false;
        }

        return true;
    }
}
