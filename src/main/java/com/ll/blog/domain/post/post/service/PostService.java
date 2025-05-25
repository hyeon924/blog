package com.ll.blog.domain.post.post.service;

import com.ll.blog.domain.post.post.entity.Post;
import com.ll.blog.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Post write(String title, String content) {
        Post post = Post.builder()
                .title(title)
                .content(content)
                .build();

        return postRepository.save(post);
    }
}