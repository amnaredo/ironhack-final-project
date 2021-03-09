package com.ironhack.coindex.repository;

import com.ironhack.coindex.model.Position;
import com.ironhack.coindex.model.PositionUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionUpdateRepository extends JpaRepository<PositionUpdate, Long> {
    List<PositionUpdate> findByPosition(Position position);
}
