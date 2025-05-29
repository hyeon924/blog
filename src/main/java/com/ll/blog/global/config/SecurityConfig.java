package com.ll.blog.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 비활성화 (API 서버에 필요 없음)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/users/signup").permitAll() // 회원가입은 인증 없이 허용
                        .anyRequest().permitAll() // 다른 요청도 지금은 모두 허용 (JWT 붙이면 이 부분 강화)
                );
        return http.build();
    }
}
