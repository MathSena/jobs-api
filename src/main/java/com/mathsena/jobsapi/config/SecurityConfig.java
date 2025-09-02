package com.mathsena.jobsapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
            auth -> {
              auth.requestMatchers("/candidates/**")
                  .permitAll()
                  .requestMatchers("/company/**")
                  .permitAll();
              auth.anyRequest().permitAll();
            });

    return http.build();
  }
}
