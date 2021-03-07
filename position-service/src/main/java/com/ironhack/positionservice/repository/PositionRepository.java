package com.ironhack.positionservice.repository;

import com.ironhack.positionservice.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Optional<Position> findByCoinId(String coinId);
    List<Position> findByIdPortfolio(Long idPortfolio);
}
