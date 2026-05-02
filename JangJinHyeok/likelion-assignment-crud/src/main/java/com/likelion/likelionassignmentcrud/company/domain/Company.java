package com.likelion.likelionassignmentcrud.company.domain;

import com.likelion.likelionassignmentcrud.game.domain.Game;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String name;
    private int establishmentYear;
    private int employeeNum;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> games = new ArrayList<>();

    @Builder
    public Company(String name, int establishmentYear, int employeeNum) {
        this.name = name;
        this.establishmentYear = establishmentYear;
        this.employeeNum = employeeNum;
    }

    public void update(String name, int employeeNum) {
        this.name = name;
        this.employeeNum = employeeNum;
    }
}