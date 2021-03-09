package com.ironhack.positionupdateservice.repository;

import com.ironhack.positionupdateservice.model.PositionUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionUpdateRepository extends JpaRepository<PositionUpdate, Long> {
    List<PositionUpdate> findByIdPosition(Long idPosition);
}
