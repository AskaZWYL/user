package com.lmh.user.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        Map<String, Object> failResult = new HashMap<String, Object>();
        failResult.put("msg", "登录失败");
        failResult.put("status", 400);
        failResult.put("失败原因", exception.getMessage());
        response.setContentType("application/json;charset=UTF-8");
        String s = new ObjectMapper().writeValueAsString(failResult);
        response.getWriter().println(s);
    }
}
