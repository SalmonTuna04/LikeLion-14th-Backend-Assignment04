package com.likelion.likelionassignmentcrud.company.api.dto.response;

import lombok.Builder;
import java.util.List;

@Builder
public record CompanyListResponseDto(
        List<CompanyInfoResponseDto> companies
) {
    public static CompanyListResponseDto from(List<CompanyInfoResponseDto> companies) {
        return CompanyListResponseDto.builder()
                .companies(companies)
                .build();
    }
}