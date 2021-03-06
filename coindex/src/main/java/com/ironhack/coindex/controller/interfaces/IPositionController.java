package com.ironhack.coindex.controller.interfaces;

import com.ironhack.coindex.dto.PositionDTO;

import java.util.List;

public interface IPositionController {

    PositionDTO getPosition(Long id);
    PositionDTO addPosition(Long idPortfolio, PositionDTO positionDTO);
    void deletePosition(Long id);

    List<PositionDTO> getPortfolioPositions(Long idPortfolio);
}
