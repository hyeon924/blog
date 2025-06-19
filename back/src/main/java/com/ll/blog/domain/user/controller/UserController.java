package com.ll.blog.domain.user.controller;

import com.ll.blog.domain.user.dto.LoginRequest;
import com.ll.blog.domain.user.dto.SignUpRequest;
import com.ll.blog.domain.user.service.UserService;
import com.ll.blog.global.response.StandardApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //    회원가입
    @PostMapping("/signup")
    public ResponseEntity<StandardApiResponse<Void>> signup(@RequestBody SignUpRequest request) {
        try {
            userService.signup(request);
            return ResponseEntity.ok(StandardApiResponse.success("회원가입 완료"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(StandardApiResponse.error(e.getMessage()));
        }
    }


    //    로그인
    @PostMapping("/login")
    public ResponseEntity<StandardApiResponse<String>> login(@RequestBody LoginRequest request) {
        String token = userService.login(request);
        return ResponseEntity.ok(StandardApiResponse.success("로그인 성공", token));
    }
}