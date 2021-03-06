package com.ironhack.coindex.repository;

import com.ironhack.coindex.model.Portfolio;
import com.ironhack.coindex.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Optional<Position> findByCoinId(String coinId);
    List<Position> findByPortfolio(Portfolio portfolio);
}
