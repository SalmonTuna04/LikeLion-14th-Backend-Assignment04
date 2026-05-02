package com.likelion.likelionassignmentcrud.game.application;

import com.likelion.likelionassignmentcrud.common.exception.BusinessException;
import com.likelion.likelionassignmentcrud.common.response.code.ErrorCode;
import com.likelion.likelionassignmentcrud.company.domain.Company;
import com.likelion.likelionassignmentcrud.company.domain.repository.CompanyRepository;
import com.likelion.likelionassignmentcrud.game.api.dto.request.GameSaveRequestDto;
import com.likelion.likelionassignmentcrud.game.api.dto.request.GameUpdateRequestDto;
import com.likelion.likelionassignmentcrud.game.api.dto.response.GameInfoResponseDto;
import com.likelion.likelionassignmentcrud.game.api.dto.response.GameListResponseDto;
import com.likelion.likelionassignmentcrud.game.domain.Game;
import com.likelion.likelionassignmentcrud.game.domain.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GameService {
    private final GameRepository gameRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    public void gameSave(GameSaveRequestDto requestDto) {
        Company company = companyRepository.findById(requestDto.companyId())
                .orElseThrow(() -> new BusinessException(ErrorCode.COMPANY_NOT_FOUND_EXCEPTION, "등록하려는 게임사의 정보가 없습니다."));
        Game game = Game.builder()
                .title(requestDto.title())
                .genre(requestDto.genre())
                .company(company)
                .build();
        gameRepository.save(game);
    }

    public GameListResponseDto gameFindCompany(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new BusinessException(ErrorCode.COMPANY_NOT_FOUND_EXCEPTION, "해당 회사의 게임목록을 조회할 수 없습니다."));
        List<Game> games = gameRepository.findByCompany(company);
        return GameListResponseDto.from(games.stream().map(GameInfoResponseDto::from).toList());
    }

    @Transactional
    public void gameUpdate(Long gameId, GameUpdateRequestDto requestDto) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new BusinessException(ErrorCode.GAME_NOT_FOUND_EXCEPTION, "수정할 게임이 없습니다."));
        game.update(requestDto.title(), requestDto.genre());
    }

    @Transactional
    public void gameDelete(Long gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new BusinessException(ErrorCode.GAME_NOT_FOUND_EXCEPTION, "삭제할 게임이 없습니다."));
        gameRepository.delete(game);
    }
}