package com.ironhack.portfolioservice.client;

import com.ironhack.portfolioservice.dto.PositionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("position-service")
public interface PositionClient {

    @GetMapping("/positions/{id}")
    PositionDTO getPosition(Long id);

    @PostMapping("/portfolios/{idPortfolio}/positions")
    PositionDTO addPosition(Long idPortfolio, PositionDTO positionDTO);

    @DeleteMapping("/positions/{id}")
    void deletePosition(Long id);

    @GetMapping("/portfolios/{idPortfolio}/positions")
    List<PositionDTO> getPortfolioPositions(Long idPortfolio);
}
