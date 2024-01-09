package com.alexdev.springboot_CRUD.config.security.filters;

import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.utils.JWTUtils;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final JWTUtils jwtUtils;
    public JWTAuthenticationFilter(JWTUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }


    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        User user = null;
        String username;
        String passwd;

        try{
            user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            username = user.getUsername();
            passwd = user.getPassword();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, passwd);

        return getAuthenticationManager().authenticate(authToken);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
        String token = jwtUtils.generateToken(user.getUsername());

        Map<String, Object> httpResponse = new LinkedHashMap<>();
        response.addHeader("Authorization", token);
        httpResponse.put("token", token);


        response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().flush();
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
