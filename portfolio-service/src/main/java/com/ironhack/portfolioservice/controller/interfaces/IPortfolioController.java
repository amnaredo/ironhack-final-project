package com.ironhack.portfolioservice.controller.interfaces;

import com.ironhack.portfolioservice.dto.PortfolioDTO;

import java.util.List;

public interface IPortfolioController {
    PortfolioDTO getPortfolio(Long id);
    PortfolioDTO addPortfolio(Long idUser, PortfolioDTO portfolioDTO);
    PortfolioDTO updatePortfolio(Long id, PortfolioDTO portfolioDTO);
    PortfolioDTO deletePortfolio(Long id);

    List<PortfolioDTO> getUserPortfolios(Long idUser);
}
