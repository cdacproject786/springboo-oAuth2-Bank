package com.bank.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
       return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/account/save")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login()
                .and()
                .formLogin()
                .disable()
                .build();
    }
}
