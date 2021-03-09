package com.ironhack.coindex.service.interfaces;

import com.ironhack.coindex.dto.PositionDTO;

import java.util.List;

public interface IPositionService {

    PositionDTO getPosition(Long id);
    PositionDTO addPosition(Long idPortfolio, PositionDTO positionDTO);
//    void updatePosition(Long id, PositionDTO positionDTO);
    void deletePosition(Long id);

    List<PositionDTO> getPortfolioPositions(Long idPortfolio);
}
