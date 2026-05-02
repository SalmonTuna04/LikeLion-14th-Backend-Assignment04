package com.likelion.likelionassignmentcrud.common.response.code;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다: "),
    COMPANY_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당 게임사를 찾을 수 없습니다."),
    GAME_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당 게임을 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다.");

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}