package com.likelion.likelionassignmentcrud.company.api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CompanyUpdateRequestDto(
        @NotBlank(message = "수정할 이름은 필수입니다.")
        String name,
        @Min(value = 1, message = "사원수는 1명 이상이어야 합니다.")
        int employeeNum
) {}