package com.ironhack.portfolioservice.controller.impl;

import com.ironhack.portfolioservice.controller.interfaces.IPortfolioController;
import com.ironhack.portfolioservice.dto.PortfolioDTO;
import com.ironhack.portfolioservice.dto.PositionDTO;
import com.ironhack.portfolioservice.dto.PositionUpdateDTO;
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

    @PutMapping("/portfolios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PortfolioDTO updatePortfolio(@PathVariable Long id, @RequestBody PortfolioDTO portfolioDTO) {
        return service.updatePortfolio(id, portfolioDTO);
    }

    @DeleteMapping("/portfolios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PortfolioDTO deletePortfolio(@PathVariable Long id) {
        return service.deletePortfolio(id);
    }

    @GetMapping("/users/{idUser}/portfolios")
    @ResponseStatus(HttpStatus.OK)
    public List<PortfolioDTO> getUserPortfolios(@PathVariable Long idUser) {
        return service.getUserPortfolios(idUser);
    }


    @PostMapping("/portfolios/{idPortfolio}/positions")
    @ResponseStatus(HttpStatus.CREATED)
    public PositionDTO addPosition(@PathVariable Long idPortfolio, @RequestBody PositionDTO positionDTO) {
        return service.addPosition(idPortfolio, positionDTO);
    }

    @DeleteMapping("/positions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PositionDTO deletePosition(@PathVariable Long id) {
        return service.deletePosition(id);
    }

    @PostMapping("/positions/{idPosition}/updates")
    @ResponseStatus(HttpStatus.CREATED)
    public PositionUpdateDTO addPositionUpdate(@PathVariable Long idPosition, @RequestBody PositionUpdateDTO positionUpdateDTO) {
        return service.addPositionUpdate(idPosition, positionUpdateDTO);
    }

    @DeleteMapping("/updates/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PositionUpdateDTO deletePositionUpdate(@PathVariable Long id) {
        return service.deletePositionUpdate(id);
    }
}
