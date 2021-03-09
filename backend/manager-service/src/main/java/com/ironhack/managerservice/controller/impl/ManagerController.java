package com.ironhack.managerservice.controller.impl;

import com.ironhack.managerservice.controller.interfaces.IManagerController;
import com.ironhack.managerservice.dto.PortfolioDTO;
import com.ironhack.managerservice.dto.PositionDTO;
import com.ironhack.managerservice.dto.PositionUpdateDTO;
import com.ironhack.managerservice.dto.UserProfileDTO;
import com.ironhack.managerservice.service.interfaces.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController implements IManagerController {

    @Autowired
    private IManagerService service;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserProfileDTO> getAllUserProfiles() {
        return service.getAllUserProfiles();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserProfileDTO getUserProfile(@PathVariable Long id) {
        return service.getUserProfile(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserProfileDTO addUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        return service.addUserProfile(userProfileDTO);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDTO userProfileDTO) {
        service.updateUserProfile(id, userProfileDTO);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserProfile(@PathVariable Long id) {
        service.deleteUserProfile(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/portfolios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PortfolioDTO getPortfolio(@PathVariable Long id) {
        return service.getPortfolio(id);
    }

    @PostMapping("/users/{idUser}/portfolios")
    @ResponseStatus(HttpStatus.CREATED)
    public PortfolioDTO addPortfolio(@PathVariable Long idUser, @RequestBody PortfolioDTO portfolioDTO) {
        return service.addPortfolio(idUser, portfolioDTO);
    }

    @PutMapping("/portfolios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePortfolio(@PathVariable Long id, @RequestBody PortfolioDTO portfolioDTO) {
        service.updatePortfolio(id, portfolioDTO);
    }

    @DeleteMapping("/portfolios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePortfolio(@PathVariable Long id) {
        service.deletePortfolio(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users/{idUser}/portfolios")
    @ResponseStatus(HttpStatus.OK)
    public List<PortfolioDTO> getUserPortfolios(@PathVariable Long idUser) {
        return service.getUserPortfolios(idUser);
    }

    @PostMapping("/portfolios/{idPortfolio}/positions")
    @ResponseStatus(HttpStatus.CREATED)
    public PositionDTO addPosition(@PathVariable Long idPortfolio, @RequestBody PositionDTO positionDTO) {
        return service.addPosition(idPortfolio, positionDTO);
    }

    @DeleteMapping("/positions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePosition(@PathVariable Long id) {
        service.deletePosition(id);
    }

    @PostMapping("/positions/{idPosition}/updates")
    @ResponseStatus(HttpStatus.CREATED)
    public PositionUpdateDTO addPositionUpdate(@PathVariable Long idPosition, @RequestBody PositionUpdateDTO positionUpdateDTO) {
        return service.addPositionUpdate(idPosition, positionUpdateDTO);
    }

    @DeleteMapping("/updates/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePositionUpdate(@PathVariable Long id) {
        service.deletePositionUpdate(id);
    }
}
