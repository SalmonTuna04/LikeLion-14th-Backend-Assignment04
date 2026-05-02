package com.likelion.likelionassignmentcrud.company.api.dto.response;

import com.likelion.likelionassignmentcrud.company.domain.Company;
import lombok.Builder;

@Builder
public record CompanyInfoResponseDto(
        Long companyId,
        String name,
        int establishmentYear,
        int employeeNum
) {
    public static CompanyInfoResponseDto from(Company company) {
        return CompanyInfoResponseDto.builder()
                .companyId(company.getCompanyId())
                .name(company.getName())
                .establishmentYear(company.getEstablishmentYear())
                .employeeNum(company.getEmployeeNum())
                .build();
    }
}