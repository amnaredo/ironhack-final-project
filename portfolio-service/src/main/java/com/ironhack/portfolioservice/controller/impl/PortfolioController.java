package com.ironhack.portfolioservice.controller.impl;

import com.ironhack.portfolioservice.controller.interfaces.IPortfolioController;
import com.ironhack.portfolioservice.dto.PortfolioDTO;
import com.ironhack.portfolioservice.service.interfaces.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PortfolioController implements IPortfolioController {
    @Autowired
    private IPortfolioService service;

    @GetMapping("/portfolios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PortfolioDTO getPortfolio(@PathVariable Long id) {
        return service.getPortfolio(id);
    }

    @PostMapping("/users/{idUser}/portfolios")
    @ResponseStatus(HttpStatus.CREATED)
    public PortfolioDTO addPortfolio(@PathVariable Long idUser, @RequestBody PortfolioDTO portfolioDTO) {
        return service.addPortfolio(idUser, portfolioDTO);
    }

    @PatchMapping("/portfolios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePortfolio(@PathVariable Long id, @RequestBody PortfolioDTO portfolioDTO) {
        service.updatePortfolio(id, portfolioDTO);
    }

    @DeleteMapping("/portfolios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePortfolio(Long id) {
        service.deletePortfolio(id);
    }

    @GetMapping("/users/{idUser}/portfolios")
    @ResponseStatus(HttpStatus.OK)
    public List<PortfolioDTO> getUserPortfolios(@RequestBody Long idUser) {
        return service.getUserPortfolios(idUser);
    }
}
