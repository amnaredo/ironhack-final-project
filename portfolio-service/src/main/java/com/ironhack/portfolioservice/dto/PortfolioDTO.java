package com.ironhack.portfolioservice.dto;

import com.ironhack.portfolioservice.model.Portfolio;
//import com.ironhack.portfolioservice.model.Position;

import java.util.ArrayList;
import java.util.List;

public class PortfolioDTO {
    private Long id;
    private String name;
    private String description;
    private List<PositionDTO> positions;
    private Long idUserProfile;

    public PortfolioDTO() {
    }

//    public PortfolioDTO(Portfolio portfolio) {
//        this();
//        this.setName(portfolio.getName());
//        this.setDescription(portfolio.getDescription());
//        this.positions = new ArrayList<>();
//        for(Position position: portfolio.getPositions()) {
//            this.positions.add(new PositionDTO(position));
//        }
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PositionDTO> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionDTO> positions) {
        this.positions = positions;
    }

    public Long getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(Long idUserProfile) {
        this.idUserProfile = idUserProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
