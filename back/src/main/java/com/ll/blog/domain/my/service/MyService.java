package com.ll.blog.domain.my.service;

import com.ll.blog.domain.my.dto.MyPageResponse;
import com.ll.blog.domain.post.entity.Post;
import com.ll.blog.domain.post.repository.PostRepository;
import com.ll.blog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ll.blog.domain.user.entity.Users;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public MyPageResponse getMyPage(String username) {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));
        List<Post> posts = postRepository.findByUser(user);
        return MyPageResponse.of(user, posts);
    }
}

