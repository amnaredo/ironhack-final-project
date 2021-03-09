package com.ironhack.managerservice.service.interfaces;

import com.ironhack.managerservice.dto.PortfolioDTO;
import com.ironhack.managerservice.dto.PositionDTO;
import com.ironhack.managerservice.dto.PositionUpdateDTO;
import com.ironhack.managerservice.dto.UserProfileDTO;

import java.util.List;

public interface IManagerService {

    List<UserProfileDTO> getAllUserProfiles();
    UserProfileDTO getUserProfile(Long id);
    UserProfileDTO addUserProfile(UserProfileDTO userProfileDTO);
    void updateUserProfile(Long id, UserProfileDTO userProfileDTO);
    void deleteUserProfile(Long id);

    PortfolioDTO getPortfolio(Long id);
    PortfolioDTO addPortfolio(Long idUser, PortfolioDTO portfolioDTO);
    void updatePortfolio(Long id, PortfolioDTO portfolioDTO);
    void deletePortfolio(Long id);
    List<PortfolioDTO> getUserPortfolios(Long idUser);

    PositionDTO addPosition(Long idPortfolio, PositionDTO positionDTO);
    void deletePosition(Long id);

    PositionUpdateDTO addPositionUpdate(Long idPosition, PositionUpdateDTO positionUpdateDTO);
    void deletePositionUpdate(Long id);


}
