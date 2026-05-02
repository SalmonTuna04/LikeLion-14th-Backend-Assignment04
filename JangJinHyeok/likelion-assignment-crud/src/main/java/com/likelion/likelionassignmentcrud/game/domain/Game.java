package com.likelion.likelionassignmentcrud.game.domain;

import com.likelion.likelionassignmentcrud.company.domain.Company;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    private String title;
    private String genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Builder
    public Game(String title, String genre, Company company) {
        this.title = title;
        this.genre = genre;
        this.company = company;
    }

    public void update(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
}