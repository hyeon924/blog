package com.ll.blog.global.response;

import lombok.Builder;
import lombok.Getter;

// 모든 API 응답을 통일된 형식으로 감싸기 위한 클래스
@Getter
@Builder
public class StandardApiResponse<T> {
    private int status; // HTTP 상태 코드
    private String message; // 응답 메시지
    private T data; // 실제 응답 데이터

//    성공 응답
    public static <T> StandardApiResponse<T> success(String message, T data) {
        return StandardApiResponse.<T>builder()
                .status(200) // HTTP 200 OK
                .message(message)
                .data(data)
                .build();
    }

    public static <T> StandardApiResponse<T> success(T data) {
        return success("성공", data);
    }

    public static StandardApiResponse<Void> success(String message) {
        return success(message, null);
    }

//    에러 응답
    public StandardApiResponse<Void> error(int status, String message) {
        return StandardApiResponse.<Void>builder()
                .status(status)
                .message(message)
                .data(null)
                .build();
    }
}
