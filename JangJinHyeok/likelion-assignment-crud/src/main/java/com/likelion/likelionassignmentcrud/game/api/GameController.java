package com.likelion.likelionassignmentcrud.game.api;

import com.likelion.likelionassignmentcrud.common.response.code.SuccessCode;
import com.likelion.likelionassignmentcrud.common.template.ApiResTemplate;
import com.likelion.likelionassignmentcrud.game.api.dto.request.GameSaveRequestDto;
import com.likelion.likelionassignmentcrud.game.api.dto.request.GameUpdateRequestDto;
import com.likelion.likelionassignmentcrud.game.api.dto.response.GameListResponseDto;
import com.likelion.likelionassignmentcrud.game.application.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    @PostMapping
    public ApiResTemplate<Void> gameSave(@RequestBody @Valid GameSaveRequestDto requestDto) {
        gameService.gameSave(requestDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.SAVE_SUCCESS);
    }

    @GetMapping("/{companyId}")
    public ApiResTemplate<GameListResponseDto> companyGameFindAll(@PathVariable Long companyId) {
        return ApiResTemplate.successResponse(SuccessCode.GET_SUCCESS, gameService.gameFindCompany(companyId));
    }

    @PatchMapping("/{gameId}")
    public ApiResTemplate<Void> gameUpdate(@PathVariable Long gameId, @RequestBody @Valid GameUpdateRequestDto requestDto) {
        gameService.gameUpdate(gameId, requestDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.UPDATE_SUCCESS);
    }

    @DeleteMapping("/{gameId}")
    public ApiResTemplate<Void> gameDelete(@PathVariable Long gameId) {
        gameService.gameDelete(gameId);
        return ApiResTemplate.successWithNoContent(SuccessCode.DELETE_SUCCESS);
    }
}