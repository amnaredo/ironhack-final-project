package com.ironhack.positionservice.controller.impl;

import com.ironhack.positionservice.controller.interfaces.IPositionController;
import com.ironhack.positionservice.dto.PositionDTO;
import com.ironhack.positionservice.service.interfaces.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PositionController implements IPositionController {
    @Autowired
    private IPositionService service;

    @GetMapping("/positions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PositionDTO getPosition(@PathVariable Long id) {
        return service.getPosition(id);
    }

    @PostMapping("/portfolios/{idPortfolio}/positions")
    @ResponseStatus(HttpStatus.CREATED)
    public PositionDTO addPosition(@PathVariable Long idPortfolio, @RequestBody PositionDTO positionDTO) {
        return service.addPosition(idPortfolio, positionDTO);
    }

    @DeleteMapping("/positions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePosition(@PathVariable Long id) {
        service.deletePosition(id);
    }

    @GetMapping("/portfolios/{idPortfolio}/positions")
    @ResponseStatus(HttpStatus.OK)
    public List<PositionDTO> getPortfolioPositions(@PathVariable Long idPortfolio) {
        return service.getPortfolioPositions(idPortfolio);
    }
}
