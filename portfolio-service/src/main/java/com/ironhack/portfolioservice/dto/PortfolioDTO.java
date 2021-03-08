package com.ironhack.portfolioservice.dto;

import com.ironhack.portfolioservice.model.Portfolio;
import java.util.List;

public class PortfolioDTO {
    private Long id;
    private String name;
    private String description;
    private List<PositionDTO> positions;
    private Long idUserProfile;

    public PortfolioDTO() {
    }

    public PortfolioDTO(Portfolio portfolio) {
        this();
        this.setId(portfolio.getId());
        this.setIdUserProfile(portfolio.getIdUserProfile());
        this.setName(portfolio.getName());
        this.setDescription(portfolio.getDescription());
    }

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
