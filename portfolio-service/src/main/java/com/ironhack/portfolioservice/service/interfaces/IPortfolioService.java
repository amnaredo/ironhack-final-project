package com.ironhack.portfolioservice.service.interfaces;

import com.ironhack.portfolioservice.dto.PortfolioDTO;

import java.util.List;

public interface IPortfolioService {
    PortfolioDTO getPortfolio(Long id);
    PortfolioDTO addPortfolio(Long idUser, PortfolioDTO portfolioDTO);
    void updatePortfolio(Long id, PortfolioDTO portfolioDTO);
    void deletePortfolio(Long id);

    List<PortfolioDTO> getUserPortfolios(Long idUser);
}
