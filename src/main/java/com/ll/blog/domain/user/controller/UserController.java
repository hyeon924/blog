package com.ll.blog.domain.user.controller;

import com.ll.blog.domain.user.dto.UserSignUpRequest;
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

    @PostMapping("/signup")
    public ResponseEntity<StandardApiResponse<Void>> signup(@RequestBody UserSignUpRequest request) {
        userService.signup(request);
        return ResponseEntity.ok(StandardApiResponse.success("회원가입 완료"));
    }
}
