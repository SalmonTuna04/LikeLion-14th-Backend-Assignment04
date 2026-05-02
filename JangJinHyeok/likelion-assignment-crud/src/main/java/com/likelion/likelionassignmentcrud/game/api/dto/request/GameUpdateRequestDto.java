package com.likelion.likelionassignmentcrud.game.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record GameUpdateRequestDto(
        @NotBlank(message = "수정할 제목을 입력하세요.")
        String title,
        @NotBlank(message = "수정할 장르를 입력하세요.")
        String genre
) {}