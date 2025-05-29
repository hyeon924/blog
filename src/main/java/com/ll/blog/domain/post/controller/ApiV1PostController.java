package com.ll.blog.domain.post.controller;

import com.ll.blog.domain.post.dto.PostRequest;
import com.ll.blog.domain.post.dto.PostResponse;
import com.ll.blog.domain.post.service.PostService;
import com.ll.blog.global.response.StandardApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 게시글 관련 API를 처리하는 REST 컨트롤러
// URL : /api/v1/posts
@RestController // REST API 전용 컨트롤러 (JSON 응답)
@RequestMapping("/api/v1/posts") // 해당 컨드롤러의 기본 url
@RequiredArgsConstructor // 의존성 주입 위한 생성자 자동 생성
public class ApiV1PostController {
    private final PostService postService;

//    게시글 생성
    @PostMapping
    public ResponseEntity<StandardApiResponse<PostResponse>> createPost(@RequestBody PostRequest request) {
        PostResponse response = postService.createAndReturn(request);
        return ResponseEntity.ok(StandardApiResponse.success("글이 작성되었습니다.", response));
    }

//    (전체) 게시글 조회
    @GetMapping
    public ResponseEntity<StandardApiResponse<List<PostResponse>>> getAllPost() {
        return ResponseEntity.ok(StandardApiResponse.success(postService.findAll()));
    }

//    (단일) 게시글 조회
    @GetMapping("/{id}")
    public ResponseEntity<StandardApiResponse<PostResponse>> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(StandardApiResponse.success(postService.findById(id)));
    }

//    게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<StandardApiResponse<PostResponse>> updatePost(@PathVariable Long id, @RequestBody PostRequest request) {
        PostResponse response = postService.updateAndReturn(id, request);
        return ResponseEntity.ok(StandardApiResponse.success("글이 수정되었습니다.", response));
    }

//    게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardApiResponse<Void>> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok(StandardApiResponse.success("글이 삭제되었습니다."));
    }
}
