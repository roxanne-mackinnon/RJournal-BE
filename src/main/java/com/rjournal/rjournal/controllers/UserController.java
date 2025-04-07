package com.rjournal.rjournal.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rjournal.rjournal.dto.UserDto;
import com.rjournal.rjournal.models.UserEntity;
import com.rjournal.rjournal.service.UserService;

@RestController
@ResponseBody
@RequestMapping(path = "/api/v1/users")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public UserDto getUser(@AuthenticationPrincipal UserDetails user, @PathVariable("id") Long id) throws UsernameNotFoundException {
        UserEntity result = userService.findUserById(id);
        return userService.toDto(result);
    }

    @GetMapping(params = {"email"})
    public UserDto getUser(@RequestParam("email") String email) {
        UserEntity result = userService.findUserByEmail(email);
        return userService.toDto(result);
    }

    
}
