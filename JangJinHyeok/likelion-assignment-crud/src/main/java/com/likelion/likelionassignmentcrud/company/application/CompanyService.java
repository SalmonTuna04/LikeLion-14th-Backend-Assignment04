package com.likelion.likelionassignmentcrud.company.application;

import com.likelion.likelionassignmentcrud.common.exception.BusinessException;
import com.likelion.likelionassignmentcrud.common.response.code.ErrorCode;
import com.likelion.likelionassignmentcrud.company.api.dto.request.CompanySaveRequestDto;
import com.likelion.likelionassignmentcrud.company.api.dto.request.CompanyUpdateRequestDto;
import com.likelion.likelionassignmentcrud.company.api.dto.response.CompanyInfoResponseDto;
import com.likelion.likelionassignmentcrud.company.domain.Company;
import com.likelion.likelionassignmentcrud.company.domain.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Transactional
    public void companySave(CompanySaveRequestDto requestDto) {
        Company company = Company.builder()
                .name(requestDto.name())
                .establishmentYear(requestDto.establishmentYear())
                .employeeNum(requestDto.employeeNum())
                .build();
        companyRepository.save(company);
    }

    public Page<CompanyInfoResponseDto> companyFindAll(Pageable pageable) {
        return companyRepository.findAll(pageable)
                .map(CompanyInfoResponseDto::from);
    }

    public CompanyInfoResponseDto companyFindOne(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new BusinessException(ErrorCode.COMPANY_NOT_FOUND_EXCEPTION, "ID: " + companyId + " 게임사를 찾을 수 없습니다."));
        return CompanyInfoResponseDto.from(company);
    }

    @Transactional
    public void companyUpdate(Long companyId, CompanyUpdateRequestDto requestDto) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new BusinessException(ErrorCode.COMPANY_NOT_FOUND_EXCEPTION, "수정할 게임사가 없습니다."));
        company.update(requestDto.name(), requestDto.employeeNum());
    }

    @Transactional
    public void companyDelete(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new BusinessException(ErrorCode.COMPANY_NOT_FOUND_EXCEPTION, "삭제할 게임사가 없습니다."));
        companyRepository.delete(company);
    }
}