package com.rjournal.rjournal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.rjournal.rjournal.service.UserService;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .httpBasic(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable())   
            .cors(Customizer.withDefaults())
            .headers(headers -> headers.frameOptions(opt -> opt.disable()))
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated());
        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService(UserService userService) {
        return (username) -> {
            UserDetails result = (UserDetails) userService.findUserByEmail(username);
            return result;
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
