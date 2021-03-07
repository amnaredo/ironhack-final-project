package com.ironhack.managerservice.client;

import com.ironhack.managerservice.dto.PortfolioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("portfolio-service")
public interface PortfolioClient {

    @GetMapping("/portfolios/{id}")
    PortfolioDTO getPortfolio(@PathVariable Long id);

    @PostMapping("/users/{idUser}/portfolios")
    PortfolioDTO addPortfolio(@PathVariable Long idUser, @RequestBody PortfolioDTO portfolioDTO);

    @PatchMapping("/portfolios/{id}")
    void updatePortfolio(@PathVariable Long id, @RequestBody PortfolioDTO portfolioDTO);

    @DeleteMapping("/portfolios/{id}")
    void deletePortfolio(@PathVariable Long id);

    @GetMapping("/users/{idUser}/portfolios")
    List<PortfolioDTO> getUserPortfolios(@PathVariable Long idUser);
}
