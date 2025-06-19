package com.ll.blog.domain.my.dto;

import com.ll.blog.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import com.ll.blog.domain.user.entity.Users;

import java.util.List;

@Getter
@AllArgsConstructor
public class MyPageResponse {
    private String nickname;
    private List<PostSimpleDto> posts;

    public static MyPageResponse of(Users user, List<Post> posts) {
        List<PostSimpleDto> postDtos = posts.stream()
                .map(PostSimpleDto::from)
                .toList();

        return new MyPageResponse(user.getNickname(), postDtos);
    }
}
