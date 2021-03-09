package com.ironhack.portfolioservice.service.interfaces;

import com.ironhack.portfolioservice.dto.PortfolioDTO;
import com.ironhack.portfolioservice.dto.PositionDTO;
import com.ironhack.portfolioservice.dto.PositionUpdateDTO;

import java.util.List;

public interface IPortfolioService {

    PortfolioDTO getPortfolio(Long id);
    PortfolioDTO addPortfolio(Long idUser, PortfolioDTO portfolioDTO);
    PortfolioDTO updatePortfolio(Long id, PortfolioDTO portfolioDTO);
    PortfolioDTO deletePortfolio(Long id);
    List<PortfolioDTO> getUserPortfolios(Long idUser);

//    PositionDTO getPosition(Long id);
    PositionDTO addPosition(Long idPortfolio, PositionDTO positionDTO);
//    PositionDTO updatePosition(Long id, PositionDTO positionDTO);
    PositionDTO deletePosition(Long id);
//    List<PositionDTO> getPortfolioPositions(Long idPortfolio);

    PositionUpdateDTO addPositionUpdate(Long idPosition, PositionUpdateDTO positionUpdateDTO);
    PositionUpdateDTO deletePositionUpdate(Long id);
}
