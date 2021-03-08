package com.ironhack.managerservice.client;

import com.ironhack.managerservice.dto.PortfolioDTO;
import com.ironhack.managerservice.dto.PositionDTO;
import com.ironhack.managerservice.dto.PositionUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("portfolio-service")
public interface PortfolioClient {

    @GetMapping("/portfolios/{id}")
    PortfolioDTO getPortfolio(@PathVariable Long id);

    @PostMapping("/users/{idUser}/portfolios")
    PortfolioDTO addPortfolio(@PathVariable Long idUser, @RequestBody PortfolioDTO portfolioDTO);

    @PutMapping("/portfolios/{id}")
    PortfolioDTO updatePortfolio(@PathVariable Long id, @RequestBody PortfolioDTO portfolioDTO);

    @DeleteMapping("/portfolios/{id}")
    PortfolioDTO deletePortfolio(@PathVariable Long id);

    @GetMapping("/users/{idUser}/portfolios")
    List<PortfolioDTO> getUserPortfolios(@PathVariable Long idUser);


    @PostMapping("/portfolios/{idPortfolio}/positions")
    PositionDTO addPosition(@PathVariable Long idPortfolio, @RequestBody PositionDTO positionDTO);

    @DeleteMapping("/positions/{id}")
    PositionDTO deletePosition(@RequestBody Long id);

    @PostMapping("/positions/{idPosition}/updates")
    PositionUpdateDTO addPositionUpdate(@PathVariable Long idPosition, @RequestBody PositionUpdateDTO positionUpdateDTO);

    @DeleteMapping("/updates/{id}")
    PositionUpdateDTO deletePositionUpdate(@PathVariable Long id);
}
