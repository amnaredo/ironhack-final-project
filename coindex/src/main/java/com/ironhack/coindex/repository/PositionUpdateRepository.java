package com.ironhack.coindex.repository;

import com.ironhack.coindex.model.PositionUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionUpdateRepository extends JpaRepository<Long, PositionUpdate> {
}
