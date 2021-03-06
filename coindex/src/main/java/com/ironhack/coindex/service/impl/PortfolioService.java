package com.ironhack.coindex.service.impl;

import com.ironhack.coindex.dto.PortfolioDTO;
import com.ironhack.coindex.model.Portfolio;
import com.ironhack.coindex.model.UserProfile;
import com.ironhack.coindex.repository.PortfolioRepository;
import com.ironhack.coindex.repository.UserProfileRepository;
import com.ironhack.coindex.service.interfaces.IPortfolioService;
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
    @Autowired
    private UserProfileRepository userProfileRepository;

    public PortfolioDTO getPortfolio(Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Portfolio portfolio = repository.findById(id).get();
        return new PortfolioDTO(portfolio);
    }

    public PortfolioDTO addPortfolio(Long idUser, PortfolioDTO portfolioDTO) {
        if (!userProfileRepository.existsById(idUser))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Portfolio portfolio = new Portfolio();
        portfolio.setName(portfolioDTO.getName());
        portfolio.setDescription(portfolio.getDescription());
        portfolio.setUserProfile(userProfileRepository.findById(idUser).get());

        return new PortfolioDTO(repository.save(portfolio));
    }

    public void updatePortfolio(Long id, PortfolioDTO portfolioDTO) {
        if (!userProfileRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Portfolio portfolio = repository.findById(id).get();
        portfolio.setName(portfolioDTO.getName());
        portfolio.setDescription(portfolioDTO.getDescription());

        repository.save(portfolio);
    }

    public void deletePortfolio(Long id) {
        if (!userProfileRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        repository.deleteById(id);
    }

    public List<PortfolioDTO> getUserPortfolios(Long idUser) {
        if (!userProfileRepository.existsById(idUser))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        UserProfile userProfile = userProfileRepository.findById(idUser).get();
        List<PortfolioDTO> portfolioDTOList = new ArrayList<>();
        for(Portfolio portfolio: userProfile.getPortfolios()){
            portfolioDTOList.add(new PortfolioDTO(portfolio));
        }

        return portfolioDTOList;
    }
}
