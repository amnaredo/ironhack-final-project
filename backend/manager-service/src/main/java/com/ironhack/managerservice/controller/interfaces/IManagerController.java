package com.ironhack.managerservice.controller.interfaces;

import com.ironhack.managerservice.dto.PortfolioDTO;
import com.ironhack.managerservice.dto.PositionDTO;
import com.ironhack.managerservice.dto.PositionUpdateDTO;
import com.ironhack.managerservice.dto.UserProfileDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IManagerController {

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
