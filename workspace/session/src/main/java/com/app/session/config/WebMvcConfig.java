package com.app.session.config;

import com.app.session.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
//    제작한 Interceptor를 주입
    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //    registry를 통해 제작한 Interceptor를 전달한다.
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/board/**") // 인터셉터 동작
//                .order() // Interceptor 우선 순위를 결정하며, 기본 값은 0이고, 숫자가 낮을 수록 우선 순위가 높다.
                .excludePathPatterns("/member/**"); // 인터셉터 미동작
    }
}


















