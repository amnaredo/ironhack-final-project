package com.ironhack.portfolioservice.service.impl;

import com.ironhack.portfolioservice.client.PositionClient;
import com.ironhack.portfolioservice.client.PositionUpdateClient;
import com.ironhack.portfolioservice.dto.PortfolioDTO;
import com.ironhack.portfolioservice.dto.PositionDTO;
import com.ironhack.portfolioservice.dto.PositionUpdateDTO;
import com.ironhack.portfolioservice.model.Portfolio;
import com.ironhack.portfolioservice.repository.PortfolioRepository;
import com.ironhack.portfolioservice.service.interfaces.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
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
    private PositionClient positionClient;

    @Autowired
    private PositionUpdateClient positionUpdateClient;

    private CircuitBreakerFactory circuitBreakerFactory = new Resilience4JCircuitBreakerFactory();


    public PortfolioDTO getPortfolio(Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Portfolio portfolio = repository.findById(id).get();
        PortfolioDTO portfolioDTO = new PortfolioDTO();
        portfolioDTO.setName(portfolio.getName());
        portfolioDTO.setDescription(portfolio.getDescription());

        portfolioDTO.setPositions(getPortfolioPositions(id));

        for(PositionDTO positionDTO: portfolioDTO.getPositions()) {
            positionDTO.setUpdates(getUpdatePositions(positionDTO.getId()));
        }

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

    public PortfolioDTO updatePortfolio(Long id, PortfolioDTO portfolioDTO) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Portfolio portfolio = repository.findById(id).get();
        portfolio.setName(portfolioDTO.getName());
        portfolio.setDescription(portfolioDTO.getDescription());

        repository.save(portfolio);
        return portfolioDTO;
    }

    public PortfolioDTO deletePortfolio(Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Portfolio portfolio = repository.findById(id).get();
        List<PositionDTO> positions = getPortfolioPositions(id);

        for(PositionDTO positionDTO: positions) {
            for(PositionUpdateDTO positionUpdateDTO: positionDTO.getUpdates()) {
                deletePositionUpdate(positionUpdateDTO.getId());
            }
            deletePosition(positionDTO.getId());
        }

        repository.deleteById(id);

        PortfolioDTO portfolioDTO = new PortfolioDTO();
        portfolioDTO.setId(id);
        portfolioDTO.setName(portfolio.getName());
        portfolioDTO.setDescription(portfolio.getDescription());
        portfolioDTO.setIdUserProfile(portfolio.getIdUserProfile());
        return portfolioDTO;
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

            portfolioDTO.setPositions(getPortfolioPositionsWithUpdates(portfolio.getId()));
            portfolioDTOList.add(portfolioDTO);
        }

        return portfolioDTOList;
    }

    private List<PositionDTO> getPortfolioPositionsWithUpdates(Long id) {

        List<PositionDTO> positions = new ArrayList<>();

        for(PositionDTO positionDTO: getPortfolioPositions(id)) {
            positionDTO.setUpdates(getUpdatePositions(positionDTO.getId()));
            positions.add(positionDTO);
        }

        return positions;
    }


    private List<PositionDTO> getPortfolioPositions(Long id) {
        CircuitBreaker cbPositionService = circuitBreakerFactory.create("position-service");

        List<PositionDTO> positions = cbPositionService.run(
                () -> positionClient.getPortfolioPositions(id),
                throwable -> getPortfolioPositionsFallback());

        return positions;
    }

    private List<PositionUpdateDTO> getUpdatePositions(Long idPosition) {
        CircuitBreaker cbPositionUpdateService = circuitBreakerFactory.create("position-update-service");

        List<PositionUpdateDTO> updates = cbPositionUpdateService.run(
                () -> positionUpdateClient.getPositionUpdates(idPosition),
                throwable -> getPositionUpdatesFallback());

        return updates;
    }


    private List<PositionDTO> getPortfolioPositionsFallback() {
        return new ArrayList<>();
    }

    private List<PositionUpdateDTO> getPositionUpdatesFallback() {
        return new ArrayList<>();
    }


    public PositionDTO addPosition(Long idPortfolio, PositionDTO positionDTO) {
        CircuitBreaker cbPositionService = circuitBreakerFactory.create("position-service");

        PositionDTO newPositionDTO = cbPositionService.run(
                () -> positionClient.addPosition(idPortfolio, positionDTO),
                throwable -> addPositionFallback());

        return newPositionDTO;
    }

    public PositionDTO deletePosition(Long idPosition) {
        CircuitBreaker cbPositionService = circuitBreakerFactory.create("position-service");

        PositionDTO positionDTO = cbPositionService.run(
                () -> positionClient.deletePosition(idPosition),
                throwable -> deletePositionFallback());

        return positionDTO;
    }


    private PositionDTO addPositionFallback() {
        return new PositionDTO();
    }

    private PositionDTO deletePositionFallback() {
        return new PositionDTO();
    }


    public PositionUpdateDTO addPositionUpdate(Long idPosition, PositionUpdateDTO positionUpdateDTO) {
        CircuitBreaker cbPositionUpdateService = circuitBreakerFactory.create("position-update-service");

        PositionUpdateDTO newPositionUpdateDTO = cbPositionUpdateService.run(
                () -> positionUpdateClient.addPositionUpdate(idPosition, positionUpdateDTO),
                throwable -> addPositionUpdateFallback());

        return newPositionUpdateDTO;
    }


    public PositionUpdateDTO deletePositionUpdate(Long idPositionUpdate) {
        CircuitBreaker cbPositionUpdateService = circuitBreakerFactory.create("position-update-service");

        PositionUpdateDTO positionUpdateDTO = cbPositionUpdateService.run(
                () -> positionUpdateClient.deletePositionUpdate(idPositionUpdate),
                throwable -> deletePositionUpdateFallback());

        return positionUpdateDTO;
    }


    private PositionUpdateDTO addPositionUpdateFallback() {
        return new PositionUpdateDTO();
    }

    private PositionUpdateDTO deletePositionUpdateFallback() {
        return new PositionUpdateDTO();
    }
}
