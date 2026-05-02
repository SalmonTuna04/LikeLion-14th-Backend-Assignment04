package com.likelion.likelionassignmentcrud.common.response.code;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessCode {
    GET_SUCCESS(HttpStatus.OK, "조회 성공"),
    SAVE_SUCCESS(HttpStatus.CREATED, "저장 성공"),
    UPDATE_SUCCESS(HttpStatus.OK, "수정 성공"),
    DELETE_SUCCESS(HttpStatus.OK, "삭제 성공");

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}