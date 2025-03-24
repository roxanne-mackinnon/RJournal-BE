package com.rjournal.rjournal.dto;

import com.rjournal.rjournal.validation.EmailConstraint;

public class UserCreationDto {
    
    @EmailConstraint
    private String email;

    private String password;

    public UserCreationDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
