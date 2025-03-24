package com.rjournal.rjournal.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator 
    implements ConstraintValidator<EmailConstraint, String> {

    Pattern emailPattern = Pattern.compile("^[a-z0-9]+@[a-z0-9]+.[a-z0-9]+$");
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        Matcher emailMatcher = emailPattern.matcher(value);
        return emailMatcher.matches();
    }
    
}
