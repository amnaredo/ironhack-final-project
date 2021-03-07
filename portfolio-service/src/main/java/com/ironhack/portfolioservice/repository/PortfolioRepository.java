package com.ironhack.portfolioservice.repository;

import com.ironhack.portfolioservice.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByIdUserProfile(Long idUserProfile);
}
