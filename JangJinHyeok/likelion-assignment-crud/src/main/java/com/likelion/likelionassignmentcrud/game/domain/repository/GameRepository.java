package com.likelion.likelionassignmentcrud.game.domain.repository;

import com.likelion.likelionassignmentcrud.company.domain.Company;
import com.likelion.likelionassignmentcrud.game.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByCompany(Company company);
}