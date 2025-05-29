package com.ll.blog.domain.user.service;

import com.ll.blog.domain.user.dto.UserSignUpRequest;
import com.ll.blog.domain.user.entity.Users;
import com.ll.blog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //의존성 주입
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void signup(UserSignUpRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("이미 사용중인 이름입니다.");
        }

        Users user = Users.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .role("ROLE_USER")
                .build();

        userRepository.save(user);
    }
}
