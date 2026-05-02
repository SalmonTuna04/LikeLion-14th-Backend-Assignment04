package com.likelion.likelionassignmentcrud.game.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GameSaveRequestDto(
        @NotNull(message = "회사 ID는 필수입니다.")
        Long companyId,
        @NotBlank(message = "제목은 필수입니다.")
        String title,
        @NotBlank(message = "장르는 필수입니다.")
        String genre
) {}