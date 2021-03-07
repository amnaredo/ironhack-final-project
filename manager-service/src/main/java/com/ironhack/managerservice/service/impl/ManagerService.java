package com.ironhack.managerservice.service.impl;

import com.ironhack.managerservice.client.PortfolioClient;
import com.ironhack.managerservice.client.UserProfileClient;
import com.ironhack.managerservice.dto.PortfolioDTO;
import com.ironhack.managerservice.dto.UserProfileDTO;
import com.ironhack.managerservice.service.interfaces.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService implements IManagerService {
    @Autowired
    private PortfolioClient portfolioClient;
    @Autowired
    private UserProfileClient userProfileClient;

    private CircuitBreakerFactory circuitBreakerFactory = new Resilience4JCircuitBreakerFactory();


    public PortfolioDTO getPortfolio(Long id) {
        CircuitBreaker cbPortfolioService = circuitBreakerFactory.create("portfolio-service");

        PortfolioDTO portfolioDTO = cbPortfolioService.run(
                () -> portfolioClient.getPortfolio(id),
                throwable -> getPortfolioFallback());

        return portfolioDTO;
    }

    public PortfolioDTO addPortfolio(Long idUser, PortfolioDTO portfolioDTO) {
        CircuitBreaker cbPortfolioService = circuitBreakerFactory.create("portfolio-service");

        return cbPortfolioService.run(
                () -> portfolioClient.addPortfolio(idUser, portfolioDTO),
                throwable -> addPortfolioFallback());
    }

    public void updatePortfolio(Long id, PortfolioDTO portfolioDTO) {
        CircuitBreaker cbPortfolioService = circuitBreakerFactory.create("portfolio-service");

        cbPortfolioService.run(
            () -> portfolioClient.updatePortfolio(id, portfolioDTO),
            throwable -> updatePortfolioFallback());
    }

    public void deletePortfolio(Long id) {
        CircuitBreaker cbPortfolioService = circuitBreakerFactory.create("portfolio-service");

        cbPortfolioService.run(
                () -> portfolioClient.deletePortfolio(id),
                throwable -> deletePortfolioFallback());
    }

    public List<PortfolioDTO> getUserPortfolios(Long idUser) {
        CircuitBreaker cbPortfolioService = circuitBreakerFactory.create("portfolio-service");

        return cbPortfolioService.run(
                () -> portfolioClient.getUserPortfolios(idUser),
                throwable -> getUserPortfoliosFallback());
    }


    private PortfolioDTO getPortfolioFallback() {
        return new PortfolioDTO();
    }
    private PortfolioDTO addPortfolioFallback() {
        return new PortfolioDTO();
    }
    private PortfolioDTO updatePortfolioFallback() {
        return new PortfolioDTO();
    }
    private PortfolioDTO deletePortfolioFallback() {
        return new PortfolioDTO();
    }
    private List<PortfolioDTO> getUserPortfoliosFallback() {
        return new ArrayList<>();
    }


    public UserProfileDTO getUserProfile(Long id) {
        CircuitBreaker cbUserProfileService = circuitBreakerFactory.create("user-profile-service");

        return cbUserProfileService.run(
                () -> userProfileClient.getUserProfile(id),
                throwable -> getUserProfileFallback());
    }

    public UserProfileDTO addUserProfile(UserProfileDTO userProfileDTO) {
        CircuitBreaker cbUserProfileService = circuitBreakerFactory.create("user-profile-service");

        return cbUserProfileService.run(
                () -> userProfileClient.addUserProfile(userProfileDTO),
                throwable -> addUserProfileFallback());
    }

    public void updateUserProfile(Long id, UserProfileDTO userProfileDTO) {
        CircuitBreaker cbUserProfileService = circuitBreakerFactory.create("user-profile-service");

        cbUserProfileService.run(
            () -> userProfileClient.updateUserProfile(id, userProfileDTO),
            throwable -> updateUserProfileFallback());
    }

    public void deleteUserProfile(Long id) {
        CircuitBreaker cbUserProfileService = circuitBreakerFactory.create("user-profile-service");

        cbUserProfileService.run(
                () -> userProfileClient.deleteUserProfile(id),
                throwable -> deleteUserProfileFallback());
    }

    private UserProfileDTO getUserProfileFallback() {
        return new UserProfileDTO();
    }
    private UserProfileDTO addUserProfileFallback() {
        return new UserProfileDTO();
    }
    private UserProfileDTO updateUserProfileFallback() {
        return new UserProfileDTO();
    }
    private UserProfileDTO deleteUserProfileFallback() {
        return new UserProfileDTO();
    }
}
