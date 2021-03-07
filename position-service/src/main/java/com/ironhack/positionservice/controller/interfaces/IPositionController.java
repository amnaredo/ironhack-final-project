package com.ironhack.positionservice.controller.interfaces;

import com.ironhack.positionservice.dto.PositionDTO;

import java.util.List;

public interface IPositionController {

    PositionDTO getPosition(Long id);
    PositionDTO addPosition(Long idPortfolio, PositionDTO positionDTO);
    void deletePosition(Long id);

    List<PositionDTO> getPortfolioPositions(Long idPortfolio);
}
