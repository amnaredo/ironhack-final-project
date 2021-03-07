package com.ironhack.managerservice.controller.interfaces;

import com.ironhack.managerservice.dto.PortfolioDTO;
import com.ironhack.managerservice.dto.UserProfileDTO;

import java.util.List;

public interface IManagerController {

    PortfolioDTO getPortfolio(Long id);
    PortfolioDTO addPortfolio(Long idUser, PortfolioDTO portfolioDTO);
    void updatePortfolio(Long id, PortfolioDTO portfolioDTO);
    void deletePortfolio(Long id);
    List<PortfolioDTO> getUserPortfolios(Long idUser);

    UserProfileDTO getUserProfile(Long id);
    UserProfileDTO addUserProfile(UserProfileDTO userProfileDTO);
    void updateUserProfile(Long id, UserProfileDTO userProfileDTO);
    void deleteUserProfile(Long id);
}
