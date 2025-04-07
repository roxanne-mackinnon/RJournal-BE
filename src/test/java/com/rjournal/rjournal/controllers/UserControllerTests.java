package com.rjournal.rjournal.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.rjournal.rjournal.service.UserService;

public class UserControllerTests {
    
    private UserController userController;

    private UserService userService;

    @BeforeEach
    public void setup() throws Exception {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }
}
