package com.ll.blog.domain.post.post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class ApiV1PostController {

    @GetMapping
    public void post() {
        return;
    }
}
