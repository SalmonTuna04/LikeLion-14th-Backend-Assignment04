package com.likelion.likelionassignmentcrud.company.api;

import com.likelion.likelionassignmentcrud.common.response.code.SuccessCode;
import com.likelion.likelionassignmentcrud.common.template.ApiResTemplate;
import com.likelion.likelionassignmentcrud.company.api.dto.request.CompanySaveRequestDto;
import com.likelion.likelionassignmentcrud.company.api.dto.request.CompanyUpdateRequestDto;
import com.likelion.likelionassignmentcrud.company.api.dto.response.CompanyInfoResponseDto;
import com.likelion.likelionassignmentcrud.company.application.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public ApiResTemplate<Void> companySave(@RequestBody @Valid CompanySaveRequestDto requestDto) {
        companyService.companySave(requestDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.SAVE_SUCCESS);
    }

    @GetMapping("/all")
    public ApiResTemplate<Page<CompanyInfoResponseDto>> companyFindAll(
            @ParameterObject @PageableDefault(size = 5) Pageable pageable
    ) {
        return ApiResTemplate.successResponse(SuccessCode.GET_SUCCESS, companyService.companyFindAll(pageable));
    }

    @GetMapping("/{companyId}")
    public ApiResTemplate<CompanyInfoResponseDto> companyFindOne(@PathVariable Long companyId) {
        return ApiResTemplate.successResponse(SuccessCode.GET_SUCCESS, companyService.companyFindOne(companyId));
    }

    @PatchMapping("/{companyId}")
    public ApiResTemplate<Void> companyUpdate(@PathVariable Long companyId, @RequestBody @Valid CompanyUpdateRequestDto requestDto) {
        companyService.companyUpdate(companyId, requestDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{companyId}")
    public ApiResTemplate<Void> companyDelete(@PathVariable Long companyId) {
        companyService.companyDelete(companyId);
        return ApiResTemplate.successWithNoContent(SuccessCode.DELETE_SUCCESS);
    }
}