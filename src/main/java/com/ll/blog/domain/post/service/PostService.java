package com.ll.blog.domain.post.service;

import com.ll.blog.domain.post.dto.PostRequest;
import com.ll.blog.domain.post.dto.PostResponse;
import com.ll.blog.domain.post.entity.Post;
import com.ll.blog.domain.post.exception.PostNotFoundException;
import com.ll.blog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// 게시글 비즈니스 로직을 담당
// controller <-> repository 사이의 중간 계층 역할
@Service // 이 클래스가 서비스 컴포넌트임을 Spring에게 알림 (Bean 등록)
@RequiredArgsConstructor // final 필드에 대해 생성자 자동 생성 (의존성주입)
public class PostService {
    private final PostRepository postRepository;

//    게시글 생성
    public PostResponse createAndReturn(PostRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        Post saved = postRepository.save(post);
        return PostResponse.from(saved);
    }

//    전체 게시글 조회
    public List<PostResponse> findAll() {
        return postRepository.findAll().stream()
                .map(PostResponse::from)
                .collect(Collectors.toList());
    }

//    단일 게시글 조회
    public PostResponse findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다."));
        return PostResponse.from(post);
    }

//    게시글 수정
    public PostResponse updateAndReturn(Long id, PostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        post.update(request.getTitle(), request.getContent());

        Post update = postRepository.save(post);
        return PostResponse.from(update);
    }

//    게시글 삭제
    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        postRepository.delete(post);
    }
}