package com.ironhack.coindex.controller.interfaces;

import com.ironhack.coindex.dto.PortfolioDTO;

import java.util.List;

public interface IPortfolioController {
    PortfolioDTO getPortfolio(Long id);
    PortfolioDTO addPortfolio(Long idUser, PortfolioDTO portfolioDTO);
    void updatePortfolio(Long id, PortfolioDTO portfolioDTO);
    void deletePortfolio(Long id);

    List<PortfolioDTO> getUserPortfolios(Long idUser);
}
