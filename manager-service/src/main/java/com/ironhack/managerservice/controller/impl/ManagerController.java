package com.ironhack.managerservice.controller.impl;

import com.ironhack.managerservice.controller.interfaces.IManagerController;
import com.ironhack.managerservice.dto.PortfolioDTO;
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

    @PatchMapping("/portfolios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePortfolio(@PathVariable Long id, @RequestBody PortfolioDTO portfolioDTO) {
        service.updatePortfolio(id, portfolioDTO);
    }

    @DeleteMapping("/portfolios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePortfolio(@PathVariable Long id) {
        service.deletePortfolio(id);
    }

    @GetMapping("/users/{idUser}/portfolios")
    @ResponseStatus(HttpStatus.OK)
    public List<PortfolioDTO> getUserPortfolios(@PathVariable Long idUser) {
        return service.getUserPortfolios(idUser);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserProfileDTO getUserProfile(@PathVariable Long id) {
        return service.getUserProfile(id);
    }

    @PostMapping("/users/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserProfileDTO addUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        return service.addUserProfile(userProfileDTO);
    }

    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserProfile(@PathVariable Long id, @RequestBody UserProfileDTO userProfileDTO) {
        service.updateUserProfile(id, userProfileDTO);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserProfile(@PathVariable Long id) {
        service.deleteUserProfile(id);
    }
}
