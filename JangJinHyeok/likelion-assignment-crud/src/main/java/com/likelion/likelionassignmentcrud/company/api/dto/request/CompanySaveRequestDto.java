package com.likelion.likelionassignmentcrud.company.api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CompanySaveRequestDto(
        @NotBlank(message = "이름은 필수입니다.")
        String name,
        @Min(value = 1900, message = "설립연도는 1900년 이후여야 합니다.")
        int establishmentYear,
        @Min(value = 1, message = "사원수는 1명 이상이어야 합니다.")
        int employeeNum
) {}