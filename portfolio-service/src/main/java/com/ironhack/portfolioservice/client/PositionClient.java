package com.ironhack.portfolioservice.client;

import com.ironhack.portfolioservice.dto.PositionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("position-service")
public interface PositionClient {

    @GetMapping("/positions/{id}")
    PositionDTO getPosition(@PathVariable Long id);

    @PostMapping("/portfolios/{idPortfolio}/positions")
    PositionDTO addPosition(@PathVariable Long idPortfolio, @RequestBody PositionDTO positionDTO);

//    @PatchMapping("/positions/{id}")
//    PositionDTO updatePosition(@PathVariable Long id, @RequestBody PositionDTO positionDTO);

    @DeleteMapping("/positions/{id}")
    PositionDTO deletePosition(@PathVariable Long id);

    @GetMapping("/portfolios/{idPortfolio}/positions")
    List<PositionDTO> getPortfolioPositions(@PathVariable Long idPortfolio);
}
