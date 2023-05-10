package com.app.session.interceptor;

import com.app.session.exception.CustomAuthenticationException;
import com.app.session.type.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//    Interceptor
//    클라이언트의 전체 요청을 가로채어 원하는 시점에 원하는 작업을 수행하도록 해준다.
//    return true일 경우, 다음 절차로 넘어가지만, false일 경우 넘어가지 않는다.
@Component
public class AuthInterceptor implements HandlerInterceptor {
//    preHandle
//    컨트롤러 수행 전
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String role = (String)request.getSession().getAttribute("role");
        if(role != null && role.equals(Role.MEMBER.name())){
            return true;
        }
//        return false;
        throw new CustomAuthenticationException();
    }

//    postHandle
//    컨트롤러 수행 후, 화면 이동 전
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

//    afterCompletion
//    다 하고 나서
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}












