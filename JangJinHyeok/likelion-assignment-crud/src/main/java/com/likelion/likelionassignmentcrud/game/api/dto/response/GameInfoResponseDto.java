package com.likelion.likelionassignmentcrud.game.api.dto.response;

import com.likelion.likelionassignmentcrud.game.domain.Game;
import lombok.Builder;

@Builder
public record GameInfoResponseDto(
        String title,
        String genre,
        String companyName
) {
    public static GameInfoResponseDto from(Game game) {
        return GameInfoResponseDto.builder()
                .title(game.getTitle())
                .genre(game.getGenre())
                .companyName(game.getCompany().getName())
                .build();
    }
}