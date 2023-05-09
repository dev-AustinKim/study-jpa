package com.app.session.interceptor;

import com.app.session.exception.CustomAuthenticationException;
import com.app.session.type.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String role = (String)request.getSession().getAttribute("role");
        if(role != null && role.equals(Role.MEMBER.name())){
            return true;
        }
//        return false;
        throw new CustomAuthenticationException();
    }
}
