package com.likelion.likelionassignmentcrud.game.api.dto.response;

import lombok.Builder;
import java.util.List;

@Builder
public record GameListResponseDto(
        List<GameInfoResponseDto> games
) {
    public static GameListResponseDto from(List<GameInfoResponseDto> games) {
        return GameListResponseDto.builder()
                .games(games)
                .build();
    }
}