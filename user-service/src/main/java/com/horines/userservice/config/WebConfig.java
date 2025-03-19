package com.horines.userservice.config;


import com.horines.userservice.models.AbstractUser;
import com.horines.userservice.repositories.AbstractUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.time.Instant;
import java.util.ArrayList;

@Configuration
@RequiredArgsConstructor
public class WebConfig {

    AbstractUserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return id -> userRepository
                    .findByUuid(id)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Bean
    public AuthenticationEntryPoint accessDeniedHandler() {
        return (HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"timestamp\":\"" + Instant.now() +
                    "\",\"status\":401,\"error\":\"Unauthorized\",\"message\": \"Provide your credentials\",\"path\":\"" + request.getRequestURI() + "\"}");
        };
    }

}