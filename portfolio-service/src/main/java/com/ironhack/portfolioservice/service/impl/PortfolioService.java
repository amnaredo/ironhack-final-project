package com.ironhack.portfolioservice.service.impl;

import com.ironhack.portfolioservice.dto.PortfolioDTO;
import com.ironhack.portfolioservice.model.Portfolio;
import com.ironhack.portfolioservice.repository.PortfolioRepository;
import com.ironhack.portfolioservice.service.interfaces.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService implements IPortfolioService {
    @Autowired
    private PortfolioRepository repository;

    public PortfolioDTO getPortfolio(Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Portfolio portfolio = repository.findById(id).get();
        PortfolioDTO portfolioDTO = new PortfolioDTO();
        portfolioDTO.setName(portfolio.getName());
        portfolioDTO.setDescription(portfolio.getDescription());
        // todo add positions
        return portfolioDTO;
    }

    public PortfolioDTO addPortfolio(Long idUser, PortfolioDTO portfolioDTO) {

        Portfolio portfolio = new Portfolio();
        portfolio.setName(portfolioDTO.getName());
        portfolio.setDescription(portfolioDTO.getDescription());
        portfolio.setUserProfile(portfolioDTO.getIdUserProfile());

        Portfolio newPortfolio = repository.save(portfolio);
        portfolioDTO.setId(newPortfolio.getId());

        return portfolioDTO;
    }

    public void updatePortfolio(Long id, PortfolioDTO portfolioDTO) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Portfolio portfolio = repository.findById(id).get();
        portfolio.setName(portfolioDTO.getName());
        portfolio.setDescription(portfolioDTO.getDescription());

        repository.save(portfolio);
    }

    public void deletePortfolio(Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        repository.deleteById(id);
    }

    public List<PortfolioDTO> getUserPortfolios(Long idUserProfile) {

        List<Portfolio> portfolios = repository.findByIdUserProfile(idUserProfile);

        List<PortfolioDTO> portfolioDTOList = new ArrayList<>();
        for(Portfolio portfolio: portfolios){
            PortfolioDTO portfolioDTO = new PortfolioDTO();
            portfolioDTO.setId(portfolio.getId());
            portfolioDTO.setName(portfolio.getName());
            portfolioDTO.setDescription(portfolio.getDescription());
            portfolioDTO.setIdUserProfile(idUserProfile);
            // todo set positions?
            portfolioDTOList.add(portfolioDTO);
        }

        return portfolioDTOList;
    }
}
