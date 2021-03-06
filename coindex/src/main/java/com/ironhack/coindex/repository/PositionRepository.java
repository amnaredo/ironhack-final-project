package com.ironhack.coindex.repository;

import com.ironhack.coindex.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Long, Position> {
}
