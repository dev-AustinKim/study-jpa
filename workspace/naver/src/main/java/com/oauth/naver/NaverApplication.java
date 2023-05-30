package com.oauth.naver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class NaverApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaverApplication.class, args);
    }

}
