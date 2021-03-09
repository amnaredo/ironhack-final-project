package com.ironhack.coindex.service.interfaces;

import com.ironhack.coindex.dto.PortfolioDTO;
import com.ironhack.coindex.dto.PositionDTO;

import java.util.List;

public interface IPortfolioService {
    PortfolioDTO getPortfolio(Long id);
    PortfolioDTO addPortfolio(Long idUser, PortfolioDTO portfolioDTO);
    void updatePortfolio(Long id, PortfolioDTO portfolioDTO);
    void deletePortfolio(Long id);

    List<PortfolioDTO> getUserPortfolios(Long idUser);
}
