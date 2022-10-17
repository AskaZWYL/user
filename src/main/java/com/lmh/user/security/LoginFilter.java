package com.lmh.user.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        if(!request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {
            return super.attemptAuthentication(request, response);
        }
        String username;
        String password;
        try {
            ServletInputStream body = request.getInputStream();
            Map<String, String> bodyParse = new ObjectMapper().readValue(body, Map.class);
            username = bodyParse.get(getUsernameParameter());
            password = bodyParse.get(getPasswordParameter());

            if (username == null) {
                username = "";
            }

            if (password == null) {
                password = "";
            }
            username = username.trim();
        } catch (IOException e) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
