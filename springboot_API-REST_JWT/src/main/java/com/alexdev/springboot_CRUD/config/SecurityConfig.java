package com.alexdev.springboot_CRUD.config;

import com.alexdev.springboot_CRUD.config.security.filters.JWTAuthenticationFilter;
import com.alexdev.springboot_CRUD.config.security.filters.JWTAuthorizationFilter;
import com.alexdev.springboot_CRUD.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final JWTUtils jwtUtils;
    private final UserDetailsService detailsService;
    private final JWTAuthorizationFilter authorizationFilter;

    @Autowired
    public SecurityConfig(JWTUtils jwtUtils, UserDetailsService detailsService, JWTAuthorizationFilter authorizationFilter) {
        this.jwtUtils = jwtUtils;
        this.detailsService = detailsService;
        this.authorizationFilter = authorizationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception {
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter(jwtUtils);
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);


        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorization -> {
                    authorization.requestMatchers(HttpMethod.GET, "/home").permitAll();
                    authorization.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
                    // matchers from open api
                    authorization.requestMatchers("/v2/api-docs").permitAll();
                    authorization.requestMatchers("/v3/api-docs").permitAll();
                    authorization.requestMatchers("/v3/api-docs/**").permitAll();
                    authorization.requestMatchers("/configuration/ui").permitAll();
                    authorization.requestMatchers("/configuration/security").permitAll();
                    authorization.requestMatchers("/webjars/**").permitAll();
                    authorization.requestMatchers("/swagger-resources").permitAll();
                    authorization.requestMatchers("/swagger-resources/**").permitAll();
                    authorization.requestMatchers("/swagger").permitAll();
                    authorization.requestMatchers("/swagger-ui.html").permitAll();
                    authorization.requestMatchers("/swagger-ui/**").permitAll();
                    authorization.anyRequest().authenticated();
                })
                .addFilter(jwtAuthenticationFilter) //Valid token
                .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class) //Valid authorization if token valid
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(detailsService)
                .passwordEncoder(passwordEncoder())
                .and().build();
    }
}